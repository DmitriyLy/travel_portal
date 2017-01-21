package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class UserDtoInfo {

    private String id;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDtoInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
