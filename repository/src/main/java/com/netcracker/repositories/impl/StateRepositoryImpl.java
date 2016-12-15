package com.netcracker.repositories.impl;

import com.netcracker.entities.State;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.StateRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by logariett on 28.11.2016.
 */
@Repository
public class StateRepositoryImpl implements IRepository<State> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;
    @Autowired
    private StateRowMapper stateRowMapper;

    @Override
    public State add(State item) {
        String query = IQueriesRepository.INSERT_STATE;
        int out = template.update(query, item.getCountryId(), item.getName());

        if (out == 0) {
            LOGGER.warn("Could not insert State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State update(State item) {
        String query = IQueriesRepository.UPDATE_STATE;
        int out = template.update(query, item.getCountryId(), item.getName(), item.getId());

        if (out == 0) {
            LOGGER.warn("Could not update State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State remove(State item) {
        String query = IQueriesRepository.DELETE_STATE;
        int out = template.update(query, item.getId());

        if (out == 0) {
            LOGGER.warn("Could not delete State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State getById(long id) {
        String query = IQueriesRepository.GET_STATE_BY_ID;
        return template.queryForObject(query,new Object[] {id}, stateRowMapper);
    }

    @Override
    public List<State> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), new StateRowMapper());
    }
}
