package com.netcracker.entities;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String socNetUserId;
    private long socialNetworkId;
    private int status;

    public User() {
    }

    public User(long id, String firstName, String lastName, String socNetUserId, long socialNetworkId, int status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.socNetUserId = socNetUserId;
        this.socialNetworkId = socialNetworkId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getSocNetUserId() {
        return socNetUserId;
    }

    public void setSocNetUserId(String socNetUserId) {
        this.socNetUserId = socNetUserId;
    }

    public long getSocialNetworkId() {
        return socialNetworkId;
    }

    public void setSocialNetworkId(long socialNetworkId) {
        this.socialNetworkId = socialNetworkId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + lastName + '\'' +
                '}';
    }
}
