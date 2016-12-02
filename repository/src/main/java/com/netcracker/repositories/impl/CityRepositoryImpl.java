package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.CityRowMapper;
import com.netcracker.specifications.Specification;
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
    private CityRowMapper rowMapper;

    @Override
    public void add(City item) {

    }

    @Override
    public void update(City item) {

    }

    @Override
    public void remove(City item) {

    }

    @Override
    public City getById(long id) {
        return null;
    }

    @Override
    public List<City> query(Specification specification) {
        return null;
    }

}
