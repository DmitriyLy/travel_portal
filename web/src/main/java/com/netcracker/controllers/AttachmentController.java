package com.netcracker.controllers;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;
import com.netcracker.entities.User;
import com.netcracker.services.Converter;
import com.netcracker.services.impl.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The controller, whose methods provide ways of interacting with
 * an authorized user comments. It is worth noting that in
 * this controller is not the method getComment (), as the comments
 * received getFullLabelInfo perform () method of the class
 * {@link com.netcracker.controllers.LabelController}.
 * <p>
 * This controller is responsible for:
 * UC17 - Adding attachments; +
 * UC18 - Deleting attachments; +
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
@RequestMapping("/labels/{labelId}/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentServiceImpl attachmentService;
    @Autowired
    private Converter converter;

    /**
     * Method of attachments extraction, depending on which label id came from client.
     * <p>
     * Described in:
     * FR14 - The system should provide the ability to view attachments;
     * FR15 - The system should provide display of attachments in accordance
     * with the order they are added to the label
     *
     * @param labelId
     * @return list of {@link AttachmentDtoInfo} - objects, that contain information about existing attachments.
     */
    @GetMapping
    public List<AttachmentDtoInfo> getAttachmentsByLabel(@PathVariable(name = "labelId") Long labelId) {
        return attachmentService.getAttachmentsByLabel(labelId)
                .stream().map(a -> converter.convertAttachmentToDtoInfo(a))
                .collect(Collectors.toList());
    }

    /**
     * Method of adding attachment to current label
     * <p>
     * Described in:
     * FR57 - The system should provide the authorized user the ability to attach files to their label.
     * FR59 - The system should provide adding file attachments from the user file system.
     *
     * @param attach - object that contains bytes of attachment.
     * @return {@link AttachmentDtoInfo} - object, that contains information about created attachment.
     */
    @PostMapping
    public AttachmentDtoInfo addAttachment(@PathVariable(name = "labelId") Long labelId, @RequestParam("attach") MultipartFile attach) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String attachmentName = attachmentService.saveAttachment(labelId, attach);
        Attachment recordFromDB = attachmentService.addAttachment(labelId, user.getUserId(), attachmentName);
        return converter.convertAttachmentToDtoInfo(recordFromDB);
    }

    /**
     * Method of deleting attachment from specified label.
     * <p>
     * Described in:
     * FR61 - The system should provide the authorized user to remove attached file from their label.
     *
     * @param attachmentId
     * @return status of deleting attachment from database //should be edit
     */
    @DeleteMapping("/{attachmentId}")
    public void deleteAttachment(@PathVariable(name = "attachmentId") Long attachmentId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            Attachment attachment = attachmentService.getAttachmentById(attachmentId);
            String attachmentOwnerId = attachment.getUserId();

            if (attachmentOwnerId.equals(user.getId())) {
                attachmentService.deleteAttachment(attachment);
            } else {
                //throw smthng
            }
            attachmentService.removeAttachment(attachment);
        }
    }
}
