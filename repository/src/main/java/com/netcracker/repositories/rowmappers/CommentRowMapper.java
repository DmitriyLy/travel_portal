package com.netcracker.repositories.rowmappers;

import com.netcracker.entities.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yuksi on 01.12.2016.
 */
public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setUserId(rs.getLong("user_id"));
        comment.setLabelId(rs.getLong("label_id"));
        comment.setCommentDate(rs.getDate("comment_date"));
        comment.setCommentText(rs.getString("comment_text"));
        return comment;
    }
}
