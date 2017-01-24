package com.netcracker.entities;

/**
 * Entity represent's ATTACHMENTS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.AttachmentRepositoryImpl
 */
public class Attachment {
    private long id;
    private String userId;
    private long labelId;
    private String name;

    public Attachment() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
