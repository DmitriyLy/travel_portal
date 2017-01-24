package com.netcracker.services.impl;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;
import com.netcracker.repositories.impl.AttachmentRepositoryImpl;
import com.netcracker.services.AttachmentService;
import com.netcracker.services.Converter;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.AttachmentsCountByLabel;
import com.netcracker.specifications.impl.AttachmentsInLabelSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 18.01.2017.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final static Logger LOGGER = LogManager.getLogger(AttachmentServiceImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AttachmentRepositoryImpl repository;
    @Autowired
    private Converter converter;


    @Override
    public AttachmentDtoInfo addAttachment(long labelId, String userId, String name) {
        Attachment attachment = new Attachment();
        attachment.setLabelId(labelId);
        attachment.setUserId(userId);
        attachment.setName(name);
        attachment = repository.add(attachment);
        return converter.convertAttachmentToDtoInfo(attachment);
    }

    @Override
    public List<AttachmentDtoInfo> getAttachmentsByLabel(Long labelId) {

        ArrayList<AttachmentDtoInfo> list = new ArrayList<>();

        SqlSpecification specification = new AttachmentsInLabelSpecification(labelId);


        List<Attachment> queryResult = repository.query(specification);

        for (Attachment item : queryResult) {
            if (item != null) {
                list.add(converter.convertAttachmentToDtoInfo(item));
            }
        }

        return list;
    }

    @Override
    public int getAttachmentCountByLabel(long labelId) {
        SqlSpecification specification = new AttachmentsCountByLabel(labelId);
        return jdbcTemplate.queryForObject(specification.toSqlQuery(), Integer.class);
    }
}
