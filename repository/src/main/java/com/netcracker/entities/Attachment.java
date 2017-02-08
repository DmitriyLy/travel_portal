package com.netcracker.entities;

/**
 * Entity represent's ATTACHMENTS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.AttachmentRepositoryImpl
 */
public class Attachment extends AbstractEntity {
    private String userId;
    private long labelId;

    public Attachment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        long id = this.getId();
        String name =  this.getName();
        Attachment that = (Attachment) o;

        if (id != that.getId()) return false;
        if (labelId != that.labelId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return name != null ? name.equals(that.getName()) : that.getName() == null;

    }

    @Override
    public int hashCode() {
        long id = this.getId();
        String name =  this.getName();
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + this.getId() +
                ", userId='" + userId + '\'' +
                ", labelId=" + labelId +
                ", name='" + this.getName() + '\'' +
                '}';
    }

    public Attachment(String userId, long labelId, String name) {
        this.userId = userId;
        this.labelId = labelId;
        this.setName(name);
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
