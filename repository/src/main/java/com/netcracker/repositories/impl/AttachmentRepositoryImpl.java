package com.netcracker.repositories.impl;

import com.netcracker.entities.Attachment;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.AttachmentRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima_2 on 30.11.2016.
 */
@Repository
public class AttachmentRepositoryImpl implements IRepository<Attachment> {
    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;
    @Autowired
    private AttachmentRowMapper attachmentRowMapper;

    @Override
    public void add(Attachment item) {
        String query = IQueriesRepository.INSERT_ATTACHMENT;

        int out = template.update(query,
                item.getUserId(), item.getLabelId(),
                item.getFilePath(), item.getName(), item.getExtension());
        if (out == 0)
            LOGGER.warn("Could not insert attachment");
    }

    @Override
    public void update(Attachment item) {
        String query = IQueriesRepository.UPDATE_ATTACHMENT;

        int out = template.update(query,
                item.getUserId(), item.getLabelId(),
                item.getFilePath(), item.getName(), item.getExtension(),
                item.getId());
        if (out == 0)
            LOGGER.warn("Could not update attachment");
    }

    @Override
    public void remove(Attachment item) {
        String query = IQueriesRepository.DELETE_ATTACHMENT;

        int out = template.update(query, item.getId());
        if (out == 0)
            LOGGER.warn("Could not delete attachment");
    }

    @Override
    public Attachment getById(long id) {
        String query = IQueriesRepository.GET_ATTACHMENT_BY_ID;
        return template.queryForObject(query,new Object[] {id}, attachmentRowMapper);
    }

    @Override
    public List<Attachment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), new AttachmentRowMapper());
    }
}
