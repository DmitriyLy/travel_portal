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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmitriy Lysai
 */
@Repository
public class AttachmentRepositoryImpl implements IRepository<Attachment> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Attachment> mapper = (rs, rowNum) -> {
        Attachment attachment = new Attachment();
        attachment.setId(rs.getLong("id"));
        attachment.setUserId(rs.getString("user_id"));
        attachment.setLabelId(rs.getLong("label_id"));
        attachment.setName(rs.getString("name"));
        return attachment;
    };

    @Override
    public Attachment add(Attachment item) {
        String query = QueriesRepository.INSERT_ATTACHMENT;
        item.setId(getNewAttachmentId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getUserId(),
                item.getLabelId(),
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert attachment");
        }

        return item;
    }

    @Override
    public Attachment update(Attachment item) {
        String query = QueriesRepository.UPDATE_ATTACHMENT;
        int out = jdbcTemplate.update(query,
                item.getUserId(),
                item.getLabelId(),
                item.getName(),
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
        int out = jdbcTemplate.update(query, item.getId());

        if (out == 0) {
            LOGGER.warn("Could not delete attachment");
        }

        return item;
    }

    @Override
    public Attachment getById(long id) {
        String query = QueriesRepository.GET_ATTACHMENT_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_ATTACHMENTS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Attachment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in ATTACHMENTS table.
     */
    private long getNewAttachmentId(){
        String query = QueriesRepository.GET_NEW_ID_ATTACHMENT;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
