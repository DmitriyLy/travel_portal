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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (id != that.id) return false;
        if (labelId != that.labelId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", labelId=" + labelId +
                ", name='" + name + '\'' +
                '}';
    }

    public Attachment(String userId, long labelId, String name) {
        this.userId = userId;
        this.labelId = labelId;
        this.name = name;
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
