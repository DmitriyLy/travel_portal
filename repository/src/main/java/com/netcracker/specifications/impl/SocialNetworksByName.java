package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by logariett on 03.12.2016.
 */
public class SocialNetworksByName implements SqlSpecification {
    private String socialNetworkName;

    public SocialNetworksByName(String socialNetworkName) {
        this.socialNetworkName = socialNetworkName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.SOCIAL_NETWORKS_BY_NAME,
                socialNetworkName);
    }
}
