package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Location;
import com.netcracker.repositories.impl.CityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class LocationRowMapper implements RowMapper<Location> {
    @Autowired
    CityRepositoryImpl cityRepository;

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setId(rs.getLong("id"));
        location.setCity(cityRepository.getById(rs.getInt("city_id")));
        location.setStreet(rs.getString("street"));
        location.setBuilding(rs.getString("building"));
        return location;
    }
}
