package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.City;
import com.netcracker.repositories.impl.StateRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dima_2 on 01.12.2016.
 */
public class CityRowMapper implements RowMapper<City> {

    @Autowired
    StateRepositoryImpl stateRepository;

    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {

        City city = new City();
        city.setId(resultSet.getInt("id"));
        city.setName(resultSet.getString("name"));

        //State state =

        return city;
    }
}
