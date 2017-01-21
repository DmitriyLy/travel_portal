package com.netcracker.repositories.impl;

import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.TagRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

    private final static Logger LOGGER = LogManager.getLogger(TagRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Tag> mapper = (rs, rowNum) -> {
        Tag tag = new Tag();
        tag.setId(rs.getLong("id"));
        tag.setName(rs.getString("name"));
        return tag;
    };

    @Override
    public Tag add(Tag item) {
        String query = QueriesRepository.INSERT_TAG;
        item.setId(getNewTagId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert Tag with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Tag update(Tag item) {
        String query = QueriesRepository.UPDATE_TAG;
        int out = jdbcTemplate.update(query,
                item.getName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update Tag with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Tag remove(Tag item) {
        String query = QueriesRepository.DELETE_TAG;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not remove Tag with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Tag getById(long id) {
        String query = QueriesRepository.GET_TAG_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_TAGS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Tag> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in TAGS table.
     */
    private long getNewTagId(){
        String query = QueriesRepository.GET_NEW_ID_TAGS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public void bindLabelAndTag(Label label, Tag tag) {
        String query = QueriesRepository.INSERT_TAGS_LABELS;
        int out = jdbcTemplate.update(query, tag.getId(), label.getId());

        if (out == 0) {
            LOGGER.warn("Cannot bind tag " + tag.toString() +
                    " to label " + label.toString());
        }
    }

    @Override
    public void unbindLabelAndTag(Label label, Tag tag) {
        String query = QueriesRepository.DELETE_TAGS_LABELS;
        int out = jdbcTemplate.update(query, tag.getId(), label.getId());

        if (out == 0) {
            LOGGER.warn("Cannot unbind tag " + tag.toString() +
                    " from label " + label.toString());
        }
    }
}
