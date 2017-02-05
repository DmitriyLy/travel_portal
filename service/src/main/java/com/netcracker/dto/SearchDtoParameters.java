package com.netcracker.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett on 12.01.2017.
 */
public class SearchDtoParameters {

    private AddressDto address;
    private List<Integer> rating;
    private List<String> categories;
    private List<String> tags;

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<Integer> getRating() {
        return rating;
    }

    public void setRating(List<Integer> rating) {
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
