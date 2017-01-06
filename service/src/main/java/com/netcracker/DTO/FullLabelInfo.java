package com.netcracker.DTO;

import com.netcracker.entities.Category;
import com.netcracker.entities.Tag;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blaze159 on 06.01.17.
 */
public class FullLabelInfo {
    private long id;
    private String authorName;
    private String setupDate;
    private String street;
    private String building;
    private byte rating;
    private String review;
    private List<Tag> tags = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private byte numberOfAttachments;
    private byte numberOfComments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(String setupDate) {
        this.setupDate = setupDate;
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

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public void setTags(List<Tag> tags) {
        this.tags = new ArrayList<>(tags);
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public void setCategories(List<Category> categories) {
        this.categories = new ArrayList<>(categories);
    }

    public byte getNumberOfAttachments() {
        return numberOfAttachments;
    }

    public void setNumberOfAttachments(byte numberOfAttachments) {
        this.numberOfAttachments = numberOfAttachments;
    }

    public byte getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(byte numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
