package com.netcracker.services;

import com.netcracker.dto.CommentDtoInfo;
import com.netcracker.dto.CommentDtoNew;
import com.netcracker.dto.CommentDtoUpdate;
import com.netcracker.entities.Comment;

import java.util.List;

/**
 * @author logariett.
 */
public interface CommentService {

    CommentDtoInfo addComment(long labelId, String userId, CommentDtoNew commentDto);
    CommentDtoInfo editComment(long commentId, CommentDtoUpdate commentDto);

    Comment getById(long commentId);
    List<Comment> getCommentsByLabel(long labelId);
    int getCommentCountByLabel(long labelId);

    void deleteComment(Comment comment);
}
