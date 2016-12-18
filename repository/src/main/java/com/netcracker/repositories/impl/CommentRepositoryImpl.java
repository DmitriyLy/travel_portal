package com.netcracker.repositories.impl;

import com.netcracker.entities.Comment;
import com.netcracker.queries.QueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements IRepository<Comment> {

    private final static Logger LOGGER = LogManager.getLogger(CommentRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate template;

    @Override
    public Comment add(Comment item) {
        String query = QueriesRepository.INSERT_COMMENT;
        int out = template.update(query,
                item.getUserId(),
                item.getLabelId(),
                item.getCommentDate(),
                item.getCommentText()
        );

        if (out == 0) {
            LOGGER.warn("Could not insert Comment = " + item.toString());
        }

        return item;
    }

    @Override
    public Comment update(Comment item) {
        String query = QueriesRepository.UPDATE_COMMENT;
        int out = template.update(query,
                item.getUserId(),
                item.getLabelId(),
                item.getCommentDate(),
                item.getCommentText(),
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not update Comment = " + item.toString());
        }

        return item;
    }

    @Override
    public Comment remove(Comment item) {
        String query = QueriesRepository.DELETE_COMMENT;
        int out = template.update(query,
                item.getId()
        );

        if (out == 0) {
            LOGGER.warn("Could not remove Comment = " + item.toString());
        }

        return item;
    }

    @Override
    public Comment getById(long id) {
        String query = QueriesRepository.GET_COMMENT_BY_ID;
        return template.queryForObject(query, new Object[]{id}, (rs, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(rs.getLong("id"));
            comment.setUserId(rs.getLong("user_id"));
            comment.setLabelId(rs.getLong("label_id"));
            comment.setCommentDate(rs.getDate("comment_date"));
            comment.setCommentText(rs.getString("comment_text"));
            return comment;
        });
    }

    @Override
    public List<Comment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), (rs, rowNum) -> {
            Comment comment = new Comment();
            comment.setId(rs.getLong("id"));
            comment.setUserId(rs.getLong("user_id"));
            comment.setLabelId(rs.getLong("label_id"));
            comment.setCommentDate(rs.getDate("comment_date"));
            comment.setCommentText(rs.getString("comment_text"));
            return comment;
        });
    }
}
