package com.netcracker.entities;

/**
 * Created by dima_2 on 30.11.2016.
 */
public class Location {
    private long id;
    private long cityId;
    private String street;
    private String building;

    public Location() {}

    public Location(long id, long cityId, String street, String building) {
        this.id = id;
        this.cityId = cityId;
        this.street = street;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (id != location.id) return false;
        if (cityId != location.cityId) return false;
        if (street != null ? !street.equals(location.street) : location.street != null) return false;
        return building != null ? building.equals(location.building) : location.building == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
