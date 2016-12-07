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
        Attachment attachment = new Attachment();
        attachment.setId(rs.getLong("id"));
        attachment.setUserId(rs.getLong("user_id"));
        attachment.setLabelId(rs.getLong("label_id"));
        attachment.setFilePath(rs.getString("file_path"));
        attachment.setName(rs.getString("name"));
        attachment.setExtension(rs.getString("extension"));
        return attachment;
    }
}
