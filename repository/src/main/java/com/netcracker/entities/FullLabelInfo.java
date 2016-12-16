package com.netcracker.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 12.12.2016.
 */
public class FullLabelInfo {
    @JsonProperty("markerId")
    private long id;
    private String ownerName;
    private String creationDate;
    @JsonProperty("latitude")
    private double coordLat;
    @JsonProperty("longtitude")
    private double coordLong;
    private String mapProvider;
    private String building;
    private String street;
    private String city;
    private String state;
    private String country;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public FullLabelInfo() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
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

    public String getMapProvider() {
        return mapProvider;
    }

    public void setMapProvider(String mapProvider) {
        this.mapProvider = mapProvider;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.addAll(categories);
        return list;
    }

    public void setCategories(List<String> categories) {
        this.categories.clear();
        this.categories.addAll(categories);
    }

    public List<String> getTags() {
        List<String> list = new ArrayList<>();
        list.addAll(tags);
        return list;
    }

    public void setTags(List<String> tags) {
        this.tags.clear();
        this.tags.addAll(tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullLabelInfo that = (FullLabelInfo) o;

        if (id != that.id) return false;
        if (Double.compare(that.coordLat, coordLat) != 0) return false;
        if (Double.compare(that.coordLong, coordLong) != 0) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (mapProvider != null ? !mapProvider.equals(that.mapProvider) : that.mapProvider != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        return tags != null ? tags.equals(that.tags) : that.tags == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        temp = Double.doubleToLongBits(coordLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordLong);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (mapProvider != null ? mapProvider.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FullLabelInfo{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", coordLat='" + coordLat + '\'' +
                ", coordLong='" + coordLong + '\'' +
                '}';
    }
}
