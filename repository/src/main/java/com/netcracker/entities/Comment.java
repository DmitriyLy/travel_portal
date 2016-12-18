package com.netcracker.entities;

import java.util.Date;

/**
 * Entity represent's COMMENTS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CommentRepositoryImpl
 */
public class Comment {
    private long id;
    private long userId;
    private long labelId;
    private Date commentDate;
    private String commentText;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (userId != comment.userId) return false;
        if (labelId != comment.labelId) return false;
        if (commentDate != null ? !commentDate.equals(comment.commentDate) : comment.commentDate != null) return false;
        return commentText != null ? commentText.equals(comment.commentText) : comment.commentText == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", labelId=" + labelId +
                ", commentDate=" + commentDate +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
