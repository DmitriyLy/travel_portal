package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Label;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelRowMapper implements RowMapper<Label> {

    @Override
    public Label mapRow(ResultSet rs, int rowNum) throws SQLException {

        Label label = new Label();
        label.setId(rs.getLong("id"));
        label.setUserId(rs.getLong("user_id"));
        label.setLocationId(rs.getLong("location_id"));
        label.setOwnerComment(rs.getString("owner_comment"));
        label.setRating(rs.getInt("rating"));
        label.setCoordLat(rs.getDouble("coordinate_lat"));
        label.setCoordLong(rs.getDouble("coordinate_long"));
        label.setCreationDate(rs.getDate("creation_date"));
        label.setMapProviderId(rs.getLong("map_provider_id"));
        return label;

    }
}
