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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements IRepository<Comment> {

    private final static Logger LOGGER = LogManager.getLogger(CommentRepositoryImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Comment> mapper = (rs, rowNum) -> {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setUserId(rs.getLong("user_id"));
        comment.setLabelId(rs.getLong("label_id"));
        comment.setCommentDate(rs.getDate("comment_date"));
        comment.setCommentText(rs.getString("comment_text"));
        return comment;
    };

    @Override
    public Comment add(Comment item) {
        String query = QueriesRepository.INSERT_COMMENT;
        //item.setId(getLastRowId());

        int out = jdbcTemplate.update(query,
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
        int out = jdbcTemplate.update(query,
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
        int out = jdbcTemplate.update(query,
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
        return jdbcTemplate.queryForObject(query, new Object[]{id}, mapper);
    }

    @Override
    public long getColumnCount() {
        String query = QueriesRepository.GET_COUNT_OF_COMMENTS;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public List<Comment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return jdbcTemplate.query(sqlSpecification.toSqlQuery(), mapper);
    }

    /**
     * @return long value - id of last row in CITIES table.
     */
    private long getLastRowId(){
        String query = QueriesRepository.GET_LAST_CITIES_ID;
        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
