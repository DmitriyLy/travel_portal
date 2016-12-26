package com.netcracker.repositories.impl;

import com.netcracker.entities.State;
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
 * @author Logariett
 */
@Repository
public class StateRepositoryImpl implements IRepository<State> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<State> mapper = (rs, rowNum) -> {
        State state = new State();
        state.setId(rs.getInt("id"));
        state.setCountryId(rs.getInt("country_id"));
        state.setName(rs.getString("name"));
        return state;
    };

    @Override
    public State add(State item) {
        String query = QueriesRepository.INSERT_STATE;
        //item.setId(getLastRowId());

        int out = jdbcTemplate.update(query,
                item.getCountryId(),
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State update(State item) {
        String query = QueriesRepository.UPDATE_STATE;
        int out = jdbcTemplate.update(query,
                item.getCountryId(),
                item.getName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State remove(State item) {
        String query = QueriesRepository.DELETE_STATE;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not delete State with name = " + item.getName()
                    + " , country = " + item.getCountryId());
        }

        return item;
    }

    @Override
    public State getById(long id) {
        String query = QueriesRepository.GET_STATE_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_STATES;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<State> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in STATES table.
     */
    private long getLastRowId(){
        String query = QueriesRepository.GET_LAST_STATE_ID;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
