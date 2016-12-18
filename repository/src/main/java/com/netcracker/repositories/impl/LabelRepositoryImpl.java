package com.netcracker.repositories.impl;

import com.netcracker.entities.Label;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.LabelRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabelRepositoryImpl implements IRepository<Label> {

    private final static Logger LOGGER = LogManager.getLogger(LabelRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LabelRowMapper labelRowMapper;

    @Override
    public Label add(Label item) {
        String query = QueriesRepository.INSERT_LABEL;
        int out = jdbcTemplate.update(query, new Object[]{
                item.getUserId(), item.getLocationId(), item.getOwnerComment(),
                item.getRating(), item.getCoordLat(), item.getCoordLong(),
                item.getCreationDate(), item.getMapProviderId()});

        if (out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public Label update(Label item) {
        String query = QueriesRepository.UPDATE_LABEL;
        int out = jdbcTemplate.update(query, new Object[]{
                item.getUserId(), item.getLocationId(), item.getOwnerComment(),
                item.getRating(), item.getCoordLat(), item.getCoordLong(),
                item.getCreationDate(), item.getMapProviderId(), item.getId()});

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public Label remove(Label item) {
        String query = QueriesRepository.DELETE_LABEL;
        int out = jdbcTemplate.update(query, new Object[]{item.getId()});

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public Label getById(long id) {
        String query = QueriesRepository.GET_LABEL_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, labelRowMapper);
    }

    @Override
    public List<Label> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), labelRowMapper);
    }
}
