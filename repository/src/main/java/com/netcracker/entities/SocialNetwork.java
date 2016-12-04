package com.netcracker.entities;

/**
 * Created by dima_2 on 30.11.2016.
 */
public class SocialNetwork {
    private int id;
    private String name;

    public SocialNetwork() {
    }

    public SocialNetwork(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
