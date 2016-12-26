package com.netcracker.repositories.impl;

import com.netcracker.entities.Configuration;
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
public class ConfigurationRepositoryImpl implements IRepository<Configuration> {

    private final static Logger LOGGER = LogManager.getLogger(ConfigurationRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Configuration> mapper = (rs, rowNum) -> {
        Configuration configuration = new Configuration();
        configuration.setConfigKey(rs.getString("configKey"));
        configuration.setConfigValue(rs.getString("configValue"));
        return configuration;
    };

    @Override
    public Configuration add(Configuration item) {
        String query = QueriesRepository.INSERT_CONFIGURATION;
        //item.setId(getLastRowId());

        int out = jdbcTemplate.update(query,
                item.getConfigKey(),
                item.getConfigValue()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert Configuration with configKey = " + item.getConfigKey() + " and configValue = " + item.getConfigValue());
        }

        return item;
    }

    @Override
    public Configuration update(Configuration item) {
        String query = QueriesRepository.UPDATE_CONFIGURATION;
        int out = jdbcTemplate.update(query,
                item.getConfigValue(),
                item.getConfigKey()
        );

        if (out == 0) {
            LOGGER.warn("Could not update Configuration with configValue = " + item.getConfigValue() + " where configKey = " + item.getConfigKey());
        }

        return item;
    }

    @Override
    public Configuration remove(Configuration item) {
        String query = QueriesRepository.DELETE_CONFIGURATION;
        int out = jdbcTemplate.update(query,
                item.getConfigKey()
        );

        if (out == 0) {
            LOGGER.warn("Could not remove Configuration with configKey = " + item.getConfigKey());
        }

        return item;
    }

    @Override
    public Configuration getById(long id) {
        String query = QueriesRepository.GET_CONFIGURATION_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_CONFIGURATIONS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Configuration> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in CONFIGURATION table.
     */
    private long getLastRowId(){
        String query = QueriesRepository.GET_LAST_CONFIGURATIONS_ID;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
