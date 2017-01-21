package com.netcracker.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LabelDtoShortInfo {

    private long id;
    private UserDtoInfo owner;
    private CoordinatesDto coordinates;
    private AddressDto address;
    private int rating;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private Date creationDate;
    private int commentCount;
    private int attachmentCount;

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

    public CoordinatesDto getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDto coordinates) {
        this.coordinates = coordinates;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    @Override
    public String toString() {
        return "LabelDtoShortInfo{" +
                "id=" + id +
                ", owner=" + owner +
                ", coordinates=" + coordinates +
                ", address=" + address +
                ", rating=" + rating +
                ", categories=" + categories +
                ", tags=" + tags +
                ", creationDate=" + creationDate +
                ", commentCount=" + commentCount +
                ", attachmentCount=" + attachmentCount +
                '}';
    }
}
