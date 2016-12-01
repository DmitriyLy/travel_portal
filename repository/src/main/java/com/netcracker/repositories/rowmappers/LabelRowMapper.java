package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Label;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class LabelRowMapper implements RowMapper<Label> {
    @Override
    public Label mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
