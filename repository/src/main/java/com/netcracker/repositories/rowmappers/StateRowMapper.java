package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.State;
import com.netcracker.repositories.impl.CountryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by logariett on 01.12.2016.
 */
public class StateRowMapper implements RowMapper<State> {
    @Autowired
    private CountryRepositoryImpl countryRepository;

    @Override
    public State mapRow(ResultSet resultSet, int i) throws SQLException {
        State state = new State();
        state.setId(resultSet.getInt("id"));
        state.setCountry(countryRepository.getById(resultSet.getInt("country_id")));
        state.setName(resultSet.getString("name"));
        return state;
    }
}
