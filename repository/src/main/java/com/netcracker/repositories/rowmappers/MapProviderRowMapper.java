package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.MapProvider;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class MapProviderRowMapper implements RowMapper<MapProvider> {
    @Override
    public MapProvider mapRow(ResultSet rs, int rowNum) throws SQLException {
        MapProvider mapProvider = new MapProvider();
        mapProvider.setId(rs.getInt("id"));
        mapProvider.setName(rs.getString("name"));
        mapProvider.setCoordSysName(rs.getString("coord_sys_name"));

        return mapProvider;
    }
}
