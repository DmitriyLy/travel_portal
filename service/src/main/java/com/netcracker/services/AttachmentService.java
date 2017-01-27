package com.netcracker.services;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author logariett.
 */
public interface AttachmentService {

    Attachment addAttachment(long labelId, String userId, String name);

    String saveAttachment(Long labelId, MultipartFile attach) throws IOException;

    List<Attachment> getAttachmentsByLabel(Long labelId);

    int getAttachmentCountByLabel(long labelId);
}
