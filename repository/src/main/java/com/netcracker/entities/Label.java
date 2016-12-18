package com.netcracker.entities;

import java.util.Date;

/**
 * Entity represent's LABELS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.LabelRepositoryImpl
 */
public class Label {

    private long id;
    private long userId;
    private long locationId;
    private String ownerComment;
    private int rating;
    private double coordLat;
    private double coordLong;
    private Date creationDate;
    private long mapProviderId;

    public Label() {
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

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getOwnerComment() {
        return ownerComment;
    }

    public void setOwnerComment(String ownerComment) {
        this.ownerComment = ownerComment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    public double getCoordLong() {
        return coordLong;
    }

    public void setCoordLong(double coordLong) {
        this.coordLong = coordLong;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getMapProviderId() {
        return mapProviderId;
    }

    public void setMapProviderId(long mapProviderId) {
        this.mapProviderId = mapProviderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        return id == label.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", coordLat=" + coordLat +
                ", coordLong=" + coordLong +
                '}';
    }
}
