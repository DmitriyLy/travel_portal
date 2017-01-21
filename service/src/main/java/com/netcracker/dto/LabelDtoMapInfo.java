package com.netcracker.dto;

import java.util.Date;

/**
 * @author logariett.
 */
public class LabelDtoMapInfo {

    private long id;
    private CoordinatesDto coordinates;
    private int rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "LabelDtoMapInfo{" +
                "id=" + id +
                ", coordinates=" + coordinates +
                ", rating=" + rating +
                ", creationDate=" + creationDate +
                '}';
    }
}
