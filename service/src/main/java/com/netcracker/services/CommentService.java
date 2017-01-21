package com.netcracker.services;

import com.netcracker.entities.Comment;

import java.util.List;

/**
 * @author logariett.
 */
public interface CommentService {

    List<Comment> getCommentsByLabel(long labelId);
    int getCommentCountByLabel(long labelId);
}
