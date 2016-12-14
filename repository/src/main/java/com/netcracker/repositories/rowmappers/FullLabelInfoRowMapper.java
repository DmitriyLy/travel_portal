package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.FullLabelInfo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dima_2 on 14.12.2016.
 */
public class FullLabelInfoRowMapper implements RowMapper<FullLabelInfo> {
    @Override
    public FullLabelInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

        FullLabelInfo fullLabelInfo = new FullLabelInfo();
        fullLabelInfo.setId(rs.getLong("id"));
        fullLabelInfo.setOwnerName(rs.getString("owner_name"));
        fullLabelInfo.setCreationDate(rs.getString("creation_date"));
        fullLabelInfo.setCoordLat(rs.getString("coordinate_lat"));
        fullLabelInfo.setCoordLong(rs.getString("coordinate_long"));
        fullLabelInfo.setMapProvider(rs.getString("map_provider"));
        fullLabelInfo.setBuilding(rs.getString("building"));
        fullLabelInfo.setStreet(rs.getString("street"));
        fullLabelInfo.setCity(rs.getString("city"));
        fullLabelInfo.setState(rs.getString("state"));
        fullLabelInfo.setCountry(rs.getString("country"));

        return fullLabelInfo;
    }
}
