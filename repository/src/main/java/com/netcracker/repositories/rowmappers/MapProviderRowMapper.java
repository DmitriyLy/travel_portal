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
        return null;
    }
}
