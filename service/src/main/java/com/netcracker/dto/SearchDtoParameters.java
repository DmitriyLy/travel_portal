package com.netcracker.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett on 12.01.2017.
 */
public class SearchDtoParameters {

    private AddressDto address;
    private int rating;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

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
}
