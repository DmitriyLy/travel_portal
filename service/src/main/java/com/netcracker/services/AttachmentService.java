package com.netcracker.services;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;

import java.util.List;

/**
 * @author logariett.
 */
public interface AttachmentService {

    Attachment addAttachment(long labelId, String userId, String name);
    List<Attachment> getAttachmentsByLabel(Long labelId);
    int getAttachmentCountByLabel(long labelId);
}
