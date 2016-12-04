package com.netcracker.repositories.impl;

import com.netcracker.entities.SocialNetwork;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.SocialNetworkRowMapper;
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
public class SocialNetworkRepositoryImpl implements IRepository<SocialNetwork> {
    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;
    @Autowired
    private SocialNetworkRowMapper socialNetworkRowMapper;

    @Override
    public void add(SocialNetwork item) {
        String query = IQueriesRepository.INSERT_SOCIAL_NETWORK;

        int out = template.update(query, item.getName());
        if (out == 0) {
            LOGGER.warn("Could not insert social network");
        }
    }

    @Override
    public void update(SocialNetwork item) {
        String query = IQueriesRepository.UPDATE_SOCIAL_NETWORK;
        int out = template.update(query, item.getName());
        if (out == 0) {
            LOGGER.warn("Could not update social network");
        }
    }

    @Override
    public void remove(SocialNetwork item) {
        String query = IQueriesRepository.DELETE_SOCIAL_NETWORK;
        int out = template.update(query, item.getId());
        if (out == 0) {
            LOGGER.warn("Could not delete social network");
        }
    }

    @Override
    public SocialNetwork getById(long id) {
        String query = IQueriesRepository.GET_SOCIAL_NETWORK_BY_ID;
        return template.queryForObject(query,new Object[] {id}, socialNetworkRowMapper);
    }

    @Override
    public List<SocialNetwork> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), new SocialNetworkRowMapper());
    }
}
