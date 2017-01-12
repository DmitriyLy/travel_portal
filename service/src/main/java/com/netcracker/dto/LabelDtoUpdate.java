package com.netcracker.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett on 12.01.2017.
 */
public class LabelDtoUpdate {

    private String review;
    private int rating;
    private List<String> categories = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

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
