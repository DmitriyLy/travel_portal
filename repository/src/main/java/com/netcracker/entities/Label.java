package com.netcracker.entities;

import java.util.Date;

/**
 * Mapping class for LABELS table.
 *
 * Created by dima_2 on 30.11.2016.
 */
public class Label {

    long id;
    User user;
    Location location;
    //Comment from user who created LABEL.
    String ownerComment;
    int rating;
    double coordLat;
    double coordLong;
    //LABEL creation date.
    //TODO this field needs more expressive name!
    Date setDate;
    MapProvider mapProvider;

    public Label() {
    }

    public Label(long id, User user, Location location, String ownerComment, int rating, double coordLat, double coordLong, Date setDate, MapProvider mapProvider) {
        this.id = id;
        this.user = user;
        this.location = location;
        this.ownerComment = ownerComment;
        this.rating = rating;
        this.coordLat = coordLat;
        this.coordLong = coordLong;
        this.setDate = setDate;
        this.mapProvider = mapProvider;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Date getDate() {
        return setDate;
    }

    public void setDate(Date date) {
        this.setDate = date;
    }

    public MapProvider getMapProvider() {
        return mapProvider;
    }

    public void setMapProvider(MapProvider mapProvider) {
        this.mapProvider = mapProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (id != label.id) return false;
        return user.equals(label.user);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", user=" + user +
                ", location=" + location +
                '}';
    }
}
