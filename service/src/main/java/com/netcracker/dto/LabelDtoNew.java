package com.netcracker.dto;

import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author logariett on 12.01.2017.
 */
public class LabelDtoNew {

    private long id;
    private CoordinatesDto coordinates;
    private AddressDto address;
    private String review;
    private int rating;
    private List<String> tags;
    private List<String> categories;
    private Date creationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "LabelDtoNew{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", address=" + address +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", tags=" + tags +
                ", categories=" + categories +
                ", creationDate=" + creationDate +
                '}';
    }
}
