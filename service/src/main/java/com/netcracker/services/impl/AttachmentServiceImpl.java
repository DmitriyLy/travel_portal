package com.netcracker.services.impl;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;
import com.netcracker.repositories.impl.AttachmentRepositoryImpl;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.AttachmentsInLabelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 18.01.2017.
 */
@Service
public class AttachmentServiceImpl {

    @Autowired
    private AttachmentRepositoryImpl repository;

    public List<AttachmentDtoInfo> getAttachmentsByLabel(Long labelId) {

        ArrayList<AttachmentDtoInfo> list = new ArrayList<>();

        SqlSpecification specification = new AttachmentsInLabelSpecification(labelId);


        List<Attachment> queryResult = repository.query(specification);

        for (Attachment item : queryResult) {

        }

        return list;
    }

}
