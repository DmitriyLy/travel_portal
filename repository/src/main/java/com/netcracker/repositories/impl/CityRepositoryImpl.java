package com.netcracker.repositories.impl;

import com.netcracker.entities.City;
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
public class CityRepositoryImpl implements IRepository<City> {

    private final static Logger LOGGER = LogManager.getLogger(CityRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<City> mapper = (rs, rowNum) -> {
        City city = new City();
        city.setId(rs.getInt("id"));
        city.setStateId(rs.getInt("state_id"));
        city.setName(rs.getString("name"));
        return city;
    };

    public City add(City item) {
        String query = QueriesRepository.INSERT_CITY;
        item.setId(getNewCityId());

        int out = jdbcTemplate.update(query,
                item.getId(),
                item.getStateId(),
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Cannot insert " + item.toString());
        }

        return item;
    }

    @Override
    public City update(City item) {
        String query = QueriesRepository.UPDATE_CITY;
        int out = jdbcTemplate.update(query,
                item.getStateId(),
                item.getName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot update " + item.toString());
        }

        return item;
    }

    @Override
    public City remove(City item) {
        String query = QueriesRepository.DELETE_CITY;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Cannot delete " + item.toString());
        }

        return item;
    }

    @Override
    public City getById(long id) {
        String query = QueriesRepository.GET_CITY_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_CITIES;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<City> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in CITIES table.
     */
    private long getNewCityId(){
        String query = QueriesRepository.GET_NEW_ID_CITY;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
