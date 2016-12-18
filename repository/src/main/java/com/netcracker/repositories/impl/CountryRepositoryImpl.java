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
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuksi
 */
@Repository
public class CountryRepositoryImpl implements IRepository<Country> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public Country add(Country item) {
        String query = QueriesRepository.INSERT_COUNTRY;
        int out = template.update(query,
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
        int out = template.update(query,
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
        int out = template.update(query,
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
        return template.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            Country country = new Country();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            return country;
        });
    }

    @Override
    public List<Country> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), (rs, rowNum) -> {
            Country country = new Country();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            return country;
        });
    }
}
