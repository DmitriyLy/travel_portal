package com.netcracker.securityConfig;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;

/**
 * Created by blaze159 on 13.01.17.
 */
public class MyUserAccountForm {

    private String id;
    private String email;
    private String userName;

    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String signInProvider;
    private String providerUserId;

    public MyUserAccountForm() {

    }

    public MyUserAccountForm(Connection<?> connection) {
        UserProfile socialUserProfile = connection.fetchUserProfile();
        this.id = null;
        this.email = socialUserProfile.getEmail();
        this.userName = socialUserProfile.getUsername();
        this.firstName = socialUserProfile.getFirstName();
        this.lastName = socialUserProfile.getLastName();

        ConnectionKey key = connection.getKey();
        // google, facebook, twitter
        this.signInProvider = key.getProviderId();

        // ID of User on google, facebook, twitter.
        // ID của User trên google, facebook, twitter.
        this.providerUserId = key.getProviderUserId();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSignInProvider() {
        return signInProvider;
    }

    public void setSignInProvider(String signInProvider) {
        this.signInProvider = signInProvider;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

}
