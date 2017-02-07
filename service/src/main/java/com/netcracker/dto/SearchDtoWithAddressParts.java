package com.netcracker.dto;

import java.util.List;

/**
 * @author logariett.
 */
public class SearchDtoWithAddressParts {

    private AddressPartsDto address;
    private List<Integer> rating;
    private List<String> categories;
    private List<String> tags;

    public AddressPartsDto getAddress() {
        return address;
    }

    public void setAddress(AddressPartsDto address) {
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
