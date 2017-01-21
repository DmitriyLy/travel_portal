package com.netcracker.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author logariett on 12.01.2017.
 */
public class LabelDtoFullInfo {

    private long id;
    private UserDtoInfo owner;
    private CoordinatesDto coordinates;
    private AddressDto address;
    private int rating;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private Date creationDate;
    private int commentCount;
    private List<AttachmentDtoInfo> attachments = new ArrayList<>();
    private String review;

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

    public List<AttachmentDtoInfo> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentDtoInfo> attachments) {
        this.attachments = attachments;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "LabelDtoFullInfo{" +
                "id=" + id +
                ", owner=" + owner +
                ", coordinates=" + coordinates +
                ", address=" + address +
                ", rating=" + rating +
                ", categories=" + categories +
                ", tags=" + tags +
                ", creationDate=" + creationDate +
                ", commentCount=" + commentCount +
                ", attachments=" + attachments +
                ", review='" + review + '\'' +
                '}';
    }
}
