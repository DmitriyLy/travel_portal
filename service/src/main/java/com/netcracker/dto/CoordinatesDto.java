package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class CoordinatesDto {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CoordinatesDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
