package com.netcracker.entities;

/**
 * Mapping class for BOOKMARKS table.
 * Provide MANY-TO-MANY relationship between USERS and LABELS.
 *
 * Created by dima_2 on 30.11.2016.
 */
public class Bookmark {

    private User user;
    private Label label;

    public Bookmark() {
    }

    public Bookmark(User user, Label label) {
        this.user = user;
        this.label = label;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookmark bookmark = (Bookmark) o;

        if (!user.equals(bookmark.user)) return false;
        return label.equals(bookmark.label);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + label.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "user=" + user +
                ", label=" + label +
                '}';
    }
}
