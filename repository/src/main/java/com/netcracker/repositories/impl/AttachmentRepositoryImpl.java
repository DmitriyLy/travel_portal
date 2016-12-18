package com.netcracker.repositories.impl;

import com.netcracker.entities.Attachment;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitriy Lysai
 */
@Repository
public class AttachmentRepositoryImpl implements IRepository<Attachment> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public Attachment add(Attachment item) {
        String query = QueriesRepository.INSERT_ATTACHMENT;
        int out = template.update(query,
                item.getUserId(),
                item.getLabelId(),
                item.getFilePath(),
                item.getName(),
                item.getExtension()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert attachment");
        }

        return item;
    }

    @Override
    public Attachment update(Attachment item) {
        String query = QueriesRepository.UPDATE_ATTACHMENT;
        int out = template.update(query,
                item.getUserId(),
                item.getLabelId(),
                item.getFilePath(),
                item.getName(),
                item.getExtension(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update attachment");
        }

        return item;
    }

    @Override
    public Attachment remove(Attachment item) {
        String query = QueriesRepository.DELETE_ATTACHMENT;
        int out = template.update(query, item.getId());

        if (out == 0) {
            LOGGER.warn("Could not delete attachment");
        }

        return item;
    }

    @Override
    public Attachment getById(long id) {
        String query = QueriesRepository.GET_ATTACHMENT_BY_ID;
        return template.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            Attachment attachment = new Attachment();
            attachment.setId(rs.getLong("id"));
            attachment.setUserId(rs.getLong("user_id"));
            attachment.setLabelId(rs.getLong("label_id"));
            attachment.setFilePath(rs.getString("file_path"));
            attachment.setName(rs.getString("name"));
            attachment.setExtension(rs.getString("extension"));
            return attachment;
        });
    }

    @Override
    public List<Attachment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), (rs, rowNum) -> {
            Attachment attachment = new Attachment();
            attachment.setId(rs.getLong("id"));
            attachment.setUserId(rs.getLong("user_id"));
            attachment.setLabelId(rs.getLong("label_id"));
            attachment.setFilePath(rs.getString("file_path"));
            attachment.setName(rs.getString("name"));
            attachment.setExtension(rs.getString("extension"));
            return attachment;
        });
    }
}
