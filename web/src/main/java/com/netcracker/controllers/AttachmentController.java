package com.netcracker.controllers;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.User;
import com.netcracker.services.impl.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * The controller, whose methods provide ways of interacting with
 * an authorized user comments. It is worth noting that in
 * this controller is not the method getComment (), as the comments
 * received getFullLabelInfo perform () method of the class
 * {@link com.netcracker.controllers.LabelController}.
 *
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

    /**
     * Method of attachments extraction, depending on which label id came from client.
     *
     * Described in:
     * FR14 - The system should provide the ability to view attachments;
     * FR15 - The system should provide display of attachments in accordance
     *      with the order they are added to the label
     *
     * @param labelId
     * @return list of {@link AttachmentDtoInfo} - objects, that contain information about existing attachments.
     */
    @GetMapping
    public List<AttachmentDtoInfo> getAttachmentsByLabel(@PathVariable(name = "labelId") Long labelId) {
        return attachmentService.getAttachmentsByLabel(labelId);
    }

    /**
     * Method of adding attachment to current label
     *
     * Described in:
     * FR57 - The system should provide the authorized user the ability to attach files to their label.
     * FR59 - The system should provide adding file attachments from the user file system.
     *
     * @param attach - object that contains bytes of attachment.
     * @return {@link AttachmentDtoInfo} - object, that contains information about created attachment.
     */
    @PostMapping("/add")
    public AttachmentDtoInfo addAttachment(HttpServletRequest request, @PathVariable(name = "labelId") Long labelId, @RequestParam("attach")MultipartFile attach) throws IOException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        String uploadRootPath = request.getServletContext().getRealPath("resources/upload/"+labelId);

        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + attach.getOriginalFilename());

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(attach.getBytes());
        stream.close();
        return null;
    }

    /**
     * Method of attachment extraction by its id
     *
     * Described in:
     * nowhere
     *
     * @param labelId
     * @param attachmentId
     * @return {@link AttachmentDtoInfo} - object, that contains information about existing attachment.
     */
    @GetMapping("/{attachmentId}")
    public AttachmentDtoInfo getAttachment(@PathVariable(name = "labelId") Long labelId,
                                           @PathVariable(name = "attachmentId") Long attachmentId) {
        return null;
    }

    /**
     * Method of deleting attachment from specified label.
     *
     * Described in:
     * FR61 - The system should provide the authorized user to remove attached file from their label.
     *
     * @param attachmentId
     * @return status of deleting attachment from database
     */
    @DeleteMapping("/{attachmentId}")
    public Integer deleteAttachment(@PathVariable(name = "labelId") Long labelId,
                                    @PathVariable(name = "attachmentId") Long attachmentId) {
        return 0;
    }
}
