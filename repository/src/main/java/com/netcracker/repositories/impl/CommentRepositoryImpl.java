package com.netcracker.repositories.impl;

import com.netcracker.entities.Comment;
import com.netcracker.queries.IQueriesRepository;
import com.netcracker.repositories.IRepository;
import com.netcracker.repositories.rowmappers.CommentRowMapper;
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

    @Autowired
    private CommentRowMapper commentRowMapper;

    @Override
    public void add(Comment item) {
        String query = IQueriesRepository.INSERT_COMMENT;
        int out = template.update(query, new Object[]{
                    item.getUser().getId(), item.getLabel().getId(), item.getCommentDate(), item.getCommentText()});
        if(out == 0) {
            LOGGER.warn("Could not insert Comment = " + item.toString());
        }
    }

    @Override
    public void update(Comment item) {
        String query = IQueriesRepository.UPDATE_COMMENT;
        int out = template.update(query, new Object[]{
                    item.getUser().getId(), item.getLabel().getId(), item.getCommentDate(), item.getCommentText(),
                    item.getId()});
        if(out == 0) {
            LOGGER.warn("Could not update Comment = " + item.toString());
        }
    }

    @Override
    public void remove(Comment item) {
        String query = IQueriesRepository.DELETE_COMMENT;
        int out = template.update(query, item.getId());
        if(out == 0) {
            LOGGER.warn("Could not remove Comment = " + item.toString());
        }
    }

    @Override
    public Comment getById(long id) {
        String query = IQueriesRepository.GET_COMMENT_BY_ID;
        return template.queryForObject(query,new Object[] {id}, commentRowMapper);
    }

    @Override
    public List<Comment> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        return template.query(sqlSpecification.toSqlQuery(), commentRowMapper);
    }
}
