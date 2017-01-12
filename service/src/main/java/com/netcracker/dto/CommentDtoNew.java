package com.netcracker.dto;

import java.util.Date;

/**
 * @author logariett
 */
public class CommentDtoNew {

    private String text;
    private Date CreationDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }
}
