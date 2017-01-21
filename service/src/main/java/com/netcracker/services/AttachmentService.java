package com.netcracker.services;

import com.netcracker.dto.AttachmentDtoInfo;

import java.util.List;

/**
 * @author logariett.
 */
public interface AttachmentService {

    List<AttachmentDtoInfo> getAttachmentsByLabel(Long labelId);
    int getAttachmentCountByLabel(long labelId);
}
