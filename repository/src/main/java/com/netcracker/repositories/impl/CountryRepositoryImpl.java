package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
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
 * @author Yuksi
 */
@Repository
public class CountryRepositoryImpl implements IRepository<Country> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Country> mapper = (rs, rowNum) -> {
        Country country = new Country();
        country.setId(rs.getInt("id"));
        country.setName(rs.getString("name"));
        return country;
    };

    @Override
    public Country add(Country item) {
        String query = QueriesRepository.INSERT_COUNTRY;
        //item.setId(getLastRowId());

        int out = jdbcTemplate.update(query,
                item.getName()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert Country with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Country update(Country item) {
        String query = QueriesRepository.UPDATE_COUNTRY;
        int out = jdbcTemplate.update(query,
                item.getName(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update Country with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Country remove(Country item) {
        String query = QueriesRepository.DELETE_COUNTRY;
        int out = jdbcTemplate.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not remove Country with name = " + item.getName());
        }

        return item;
    }

    @Override
    public Country getById(long id) {
        String query = QueriesRepository.GET_COUNTRY_BY_ID;
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_COUNTRIES;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Country> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in COUNTRY table.
     */
    private long getLastRowId(){
        String query = QueriesRepository.GET_LAST_COUNTRY_ID;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
