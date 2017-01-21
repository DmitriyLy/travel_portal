package com.netcracker.dto;

import java.util.Date;

/**
 * @author logariett
 */
public class CommentDtoInfo {

    private long id;
    private UserDtoInfo owner;
    private String text;
    private Date creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDtoInfo getOwner() {
        return owner;
    }

    public void setOwner(UserDtoInfo owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CommentDtoInfo{" +
                "id=" + id +
                ", owner=" + owner +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
