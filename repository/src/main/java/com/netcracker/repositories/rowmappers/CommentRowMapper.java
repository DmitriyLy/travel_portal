package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Comment;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.repositories.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class CommentRowMapper implements RowMapper<Comment> {
    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    LabelRepositoryImpl labelRepository;

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setUser(userRepository.getById(rs.getLong("user_id")));
        comment.setLabel(labelRepository.getById(rs.getLong("label_id")));
        comment.setCommentDate(rs.getDate("comment_date"));
        comment.setCommentText(rs.getString("comment_text"));
        return comment;
    }
}
