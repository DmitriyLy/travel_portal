package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.CountryRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yuksi on 25.11.2016.
 */
@Repository
public class CountryRepositoryImpl implements IRepository<Country> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private CountryRowMapper countryRowMapper;

    @Override
    public void add(Country item) {
        String query = IQueriesRepository.INSERT_COUNTRY;
        int out = template.update(query, new Object[]{item.getName()});
        if(out == 0) {
            LOGGER.warn("Could not insert Country with name = " + item.getName());
        }
    }

    @Override
    public void update(Country item) {
        String query = IQueriesRepository.UPDATE_COUNTRY;
        int out = template.update(query, new Object[]{item.getName(), item.getId()});
        if(out == 0) {
            LOGGER.warn("Could not update Country with name = " + item.getName());
        }
    }

    @Override
    public void remove(Country item) {
        String query = IQueriesRepository.DELETE_COUNTRY;
        int out = template.update(query, item.getId());
        if(out == 0) {
            LOGGER.warn("Could not remove Country with name = " + item.getName());
        }
    }

    @Override
    public Country getById(long id) {
        String query = IQueriesRepository.GET_COUNTRY_BY_ID;
        return template.queryForObject(query,new Object[] {id}, countryRowMapper);
    }

    @Override
    public List<Country> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), countryRowMapper);
    }
}
