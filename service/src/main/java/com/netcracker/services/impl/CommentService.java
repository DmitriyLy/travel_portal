package com.netcracker.services.impl;

import com.netcracker.entities.Comment;
import com.netcracker.repositories.impl.CommentRepositoryImpl;
import com.netcracker.services.IService;
import com.netcracker.specifications.impl.CommentsOnLabelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuksi on 11.12.2016.
 */
@Service
@Transactional
public class CommentService implements IService<Comment> {

    @Autowired
    private CommentRepositoryImpl commentRepository;

    @Override
    public void save(Comment item) {
        commentRepository.add(item);
    }

    @Override
    public void update(Comment item) {
        commentRepository.update(item);
    }

    @Override
    public void delete(Comment item) {
        commentRepository.remove(item);
    }

    public List<Comment> getCommentsByLabelId(long labelId) {
        return commentRepository.query(new CommentsOnLabelSpecification(labelId));
    }

    public Comment getById(long commntId) {
        return commentRepository.getById(commntId);
    }
    
}
