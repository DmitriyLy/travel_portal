package com.netcracker.entities;


import java.util.Date;

public class Comment {
    private long id;
    private User user;
    private Label label;
    private Date commentDate;
    private String commentText;

    public Comment() {}
    public Comment(long id, User user, Label label, Date commentDate, String commentText) {
        this.id = id;
        this.user = user;
        this.label = label;
        this.commentDate = commentDate;
        this.commentText = commentText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;
        if (label != null ? !label.equals(comment.label) : comment.label != null) return false;
        if (commentDate != null ? !commentDate.equals(comment.commentDate) : comment.commentDate != null) return false;
        return commentText != null ? commentText.equals(comment.commentText) : comment.commentText == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (commentDate != null ? commentDate.hashCode() : 0);
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", label=" + label +
                ", commentDate=" + commentDate +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
