package com.netcracker.repositories.impl;

import com.netcracker.entities.Country;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Created by Yuksi on 25.11.2016.
 */
@Repository
public class CountryRepositoryImpl implements com.netcracker.repositories.Repository<Country> {

    private final static Logger LOGGER = LogManager.getLogger(CountryRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public void add(Country item) {
        String query = "INSERT INTO COUNTRIES(id,name) values(?,?)";
        int out = template.update(query, new Object[]{item.getId(), item.getName()});
        if(out == 0) {
            LOGGER.warn("Could not update Country with name = " + item.getName());
        }
    }

    @Override
    public void update(Country item) {
        String query = "UPDATE COUNTRIES SET name=? WHERE id=?";
        int out = template.update(query, new Object[]{item.getName(), item.getId()});
        if(out == 0) {
            LOGGER.warn("Could not update Country with name = " + item.getName());
        }
    }

    @Override
    public void remove(Country item) {
        String query = "DELETE FROM COUNTRIES WHERE id=?";
        int out = template.update(query, item.getId());
        if(out == 0) {
            LOGGER.warn("Could not remove Country with name = " + item.getName());
        }
    }

    @Override
    public List<Country> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), new CountryRowMapper());
    }

    class CountryRowMapper implements RowMapper<Country>
    {
        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            return country;
        }
    }
}
