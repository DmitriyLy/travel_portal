package com.netcracker.entities;

/**
 * Entity represent's SOCIAL_NETWORKS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.SocialNetworkRepositoryImpl
 */
public class SocialNetwork {
    private long id;
    private String name;

    public SocialNetwork() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
