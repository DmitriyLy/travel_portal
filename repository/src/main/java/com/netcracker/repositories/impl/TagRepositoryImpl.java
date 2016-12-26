package com.netcracker.repositories.impl;

import com.netcracker.entities.Tag;
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

@Repository
public class TagRepositoryImpl implements IRepository<Tag> {

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
        //item.setId(getLastRowId());

        int out = jdbcTemplate.update(query,
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
    private long getLastRowId(){
        String query = QueriesRepository.GET_LAST_TAGS_ID;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
