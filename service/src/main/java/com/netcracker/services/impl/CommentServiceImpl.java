package com.netcracker.services.impl;

import com.netcracker.dto.CommentDtoInfo;
import com.netcracker.dto.CommentDtoNew;
import com.netcracker.dto.CommentDtoUpdate;
import com.netcracker.entities.Comment;
import com.netcracker.repositories.impl.CommentRepositoryImpl;
import com.netcracker.services.CommentService;
import com.netcracker.services.Converter;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.CommentsCountByLabel;
import com.netcracker.specifications.impl.CommentsOnLabelSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
    @Autowired
    private Converter converter;


    @Override
    public CommentDtoInfo addComment(long labelId, String userId, CommentDtoNew commentDto) {
        Comment comment = new Comment();
        comment.setLabelId(labelId);
        comment.setUserId(userId);
        comment.setCommentText(commentDto.getText());
        comment.setCommentDate(new Date(new java.util.Date().getTime()));
        comment = commentRepository.add(comment);
        return converter.convertCommentToDtoInfo(comment);
    }

    @Override
    public CommentDtoInfo editComment(long commentId, CommentDtoUpdate commentDto) {
        Comment comment = commentRepository.getById(commentId);
        comment.setCommentText(commentDto.getText());
        comment = commentRepository.update(comment);
        return converter.convertCommentToDtoInfo(comment);
    }

    @Override
    public Comment getById(long commentId) {
        return commentRepository.getById(commentId);
    }

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

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.remove(comment);
    }
}
