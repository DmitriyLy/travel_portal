package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Attachment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class AttachmentRowMapper implements RowMapper<Attachment> {
    @Override
    public Attachment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
