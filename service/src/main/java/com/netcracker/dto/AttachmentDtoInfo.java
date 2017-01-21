package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class AttachmentDtoInfo {

    private long id;
    private String thumbnail;
    private String large;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "AttachmentDtoInfo{" +
                "id=" + id +
                ", thumbnail='" + thumbnail + '\'' +
                ", large='" + large + '\'' +
                '}';
    }
}
