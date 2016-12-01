package com.netcracker.entities;

/**
 * Mapping class for USER table.
 *
 * Created by dima_2 on 30.11.2016.
 */
public class User {

    long id;
    String firstName;
    String secondName;
    //ID from Social Networks, used for authorization.
    String socNetUserId;
    SocialNetwork socialNetwork;
    int status;

    public User() {
    }

    public User(long id, String firstName, String secondName, String socNetUserId, SocialNetwork socialNetwork, int status) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.socNetUserId = socNetUserId;
        this.socialNetwork = socialNetwork;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSocNetUserId() {
        return socNetUserId;
    }

    public void setSocNetUserId(String socNetUserId) {
        this.socNetUserId = socNetUserId;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
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

        if (id != user.id) return false;
        if (!firstName.equals(user.firstName)) return false;
        return secondName.equals(user.secondName);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
