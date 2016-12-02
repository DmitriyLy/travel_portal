package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.CityRowMapper;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import oracle.net.aso.q;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by dima_2 on 30.11.2016.
 */
public class CityRepositoryImpl implements IRepository<City> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private CityRowMapper cityRowMapper;

    @Override
    public void add(City item) {

        String query = IQueriesRepository.INSERT_CITY;
        int out = template.update(query, new Object[]{item.getState().getId(), item.getName()});
        if(out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }
    }

    @Override
    public void update(City item) {

        String query = IQueriesRepository.UPDATE_CITY;
        int out = template.update(query, new Object[]{item.getState().getId(), item.getName(), item.getId()});
        if(out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }
    }

    @Override
    public void remove(City item) {

        String query = IQueriesRepository.DELETE_CITY;
        int out = template.update(query, new Object[]{item.getId()});
        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }
    }

    @Override
    public City getById(long id) {
        String query = IQueriesRepository.GET_COMMENT_BY_ID;
        return template.queryForObject(query,new Object[] {id}, cityRowMapper);
    }

    @Override
    public List<City> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), cityRowMapper);
    }

}
