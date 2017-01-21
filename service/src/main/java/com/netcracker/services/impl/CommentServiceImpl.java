package com.netcracker.services.impl;

import com.netcracker.entities.Comment;
import com.netcracker.repositories.impl.CommentRepositoryImpl;
import com.netcracker.services.CommentService;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.CommentsCountByLabel;
import com.netcracker.specifications.impl.CommentsOnLabelSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class CommentServiceImpl implements CommentService {
    private final static Logger LOGGER = LogManager.getLogger(CommentServiceImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CommentRepositoryImpl commentRepository;


    @Override
    public List<Comment> getCommentsByLabel(long labelId) {
        Specification specification = new CommentsOnLabelSpecification(labelId);
        return commentRepository.query(specification);
    }

    @Override
    public int getCommentCountByLabel(long labelId) {
        SqlSpecification specification = new CommentsCountByLabel(labelId);
        return jdbcTemplate.queryForObject(specification.toSqlQuery(), Integer.class);
    }
}
