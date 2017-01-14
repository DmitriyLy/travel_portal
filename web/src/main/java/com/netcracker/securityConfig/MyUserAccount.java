package com.netcracker.securityConfig;

/**
 * Created by blaze159 on 13.01.17.
 */
public class MyUserAccount {

    public static final String ROLE_USER = "ROLE_USER";

    private String id;
    private String email;
    private String userName;

    private String firstName;
    private String lastName;
    private String role;

    public MyUserAccount() {

    }

    public MyUserAccount(String id, String email, String userName,
                         String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
