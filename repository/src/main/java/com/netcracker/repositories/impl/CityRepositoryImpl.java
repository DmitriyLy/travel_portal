package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dima_2 on 30.11.2016.
 */
public class CityRepositoryImpl implements IRepository<City> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

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
    public City getById(int id) {
        return null;
    }

    @Override
    public List<City> query(Specification specification) {
        return null;
    }

    class CityRowMapper implements RowMapper<City> {

        @Override
        public City mapRow(ResultSet resultSet, int i) throws SQLException {

            City city = new City();
            city.setId(resultSet.getInt("id"));
            city.setName(resultSet.getString("name"));


            return city;
        }
    }
}
