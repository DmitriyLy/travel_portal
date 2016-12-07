package com.netcracker.entities;


/**
 * Created by dima_2 on 30.11.2016.
 */
public class Attachment {
    private long id;
    private long userId;
    private long labelId;
    private String filePath;
    private String name;
    private String extension;

    public Attachment() {
    }

    public Attachment(long id, long userId, long labelId, String filePath, String name, String extension) {
        this.id = id;
        this.userId = userId;
        this.labelId = labelId;
        this.filePath = filePath;
        this.name = name;
        this.extension = extension;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (labelId != that.labelId) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return extension != null ? extension.equals(that.extension) : that.extension == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (labelId ^ (labelId >>> 32));
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", userId=" + userId +
                ", labelId=" + labelId +
                ", filePath='" + filePath + '\'' +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
