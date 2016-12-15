package com.netcracker.repositories.impl;

import com.netcracker.entities.User;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.UserRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements IRepository<User> {

    private final static Logger LOGGER = LogManager.getLogger(UserRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRowMapper userRowMapper;

    @Override
    public User add(User item) {
        String query = IQueriesRepository.INSERT_USER;
        int out = jdbcTemplate.update(query, new Object[]{
                item.getFirstName(), item.getLastName(), item.getSocNetUserId(),
                item.getSocialNetworkId(), item.getStatus()});

        if(out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public User update(User item) {
        String query = IQueriesRepository.UPDATE_USER;
        int out = jdbcTemplate.update(query, new Object[]{
                item.getFirstName(), item.getLastName(), item.getSocNetUserId(),
                item.getSocialNetworkId(), item.getStatus(), item.getId()});

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public User remove(User item) {
        String query = IQueriesRepository.DELETE_USER;
        int out = jdbcTemplate.update(query, new Object[]{item.getId()});

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public User getById(long id) {
        String query = IQueriesRepository.GET_USER_BY_ID;
        return jdbcTemplate.queryForObject(query,new Object[] {id}, userRowMapper);
    }

    @Override
    public List<User> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), userRowMapper);
    }
}
