package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Attachment;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.repositories.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class AttachmentRowMapper implements RowMapper<Attachment> {

    @Autowired
    private UserRepositoryImpl userRepository;
    @Autowired
    private LabelRepositoryImpl labelRepository;

    @Override
    public Attachment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Attachment attachment = new Attachment();
        attachment.setId(rs.getLong("id"));
        attachment.setUser(userRepository.getById(rs.getLong("user_id")));
        attachment.setLabel(labelRepository.getById(rs.getLong("label_id")));
        attachment.setFilePath(rs.getString("file_path"));
        attachment.setName(rs.getString("name"));
        attachment.setExtension(rs.getString("extension"));
        return attachment;
    }
}
