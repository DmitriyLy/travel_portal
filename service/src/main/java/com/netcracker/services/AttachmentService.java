package com.netcracker.services;

import com.netcracker.dto.AttachmentDtoInfo;

import java.util.List;

/**
 * @author logariett.
 */
public interface AttachmentService {

    AttachmentDtoInfo addAttachment(long labelId, String userId, String name);
    List<AttachmentDtoInfo> getAttachmentsByLabel(Long labelId);
    int getAttachmentCountByLabel(long labelId);
}
