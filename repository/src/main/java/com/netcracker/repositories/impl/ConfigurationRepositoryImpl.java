package com.netcracker.repositories.impl;

import com.netcracker.entities.Configuration;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.ConfigurationRowMapper;
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
public class ConfigurationRepositoryImpl implements IRepository<Configuration> {
    private final static Logger LOGGER = LogManager.getLogger(ConfigurationRepositoryImpl.class.getName());
    @Autowired
    private JdbcTemplate template;
    @Autowired
    private ConfigurationRowMapper configurationRowMapper;

    @Override
    public void add(Configuration item) {
        String query = IQueriesRepository.INSERT_CONFIGURATION;
        int out = template.update(query, item.getConfigKey(), item.getConfigValue());
        if(out == 0) {
            LOGGER.warn("Could not insert Configuration with configKey = " + item.getConfigKey() + " and configValue = " + item.getConfigValue());
        }
    }

    @Override
    public void update(Configuration item) {
        String query = IQueriesRepository.UPDATE_CONFIGURATION;
        int out = template.update(query, item.getConfigValue(), item.getConfigKey());
        if(out == 0) {
            LOGGER.warn("Could not update Configuration with configValue = " + item.getConfigValue() + " where configKey = " + item.getConfigKey());
        }
    }

    @Override
    public void remove(Configuration item) {
        String query = IQueriesRepository.DELETE_CONFIGURATION;
        int out = template.update(query, item.getConfigKey());
        if(out == 0) {
            LOGGER.warn("Could not remove Configuration with configKey = " + item.getConfigKey());
        }
    }

    @Override
    public Configuration getById(long id) {
        String query = IQueriesRepository.GET_CONFIGURATION_BY_ID;
        return template.queryForObject(query,new Object[] {id}, configurationRowMapper);
    }

    @Override
    public List<Configuration> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), configurationRowMapper);
    }
}
