package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Logariett
 */
public class SocialNetworksByName implements SqlSpecification {
    private String socialNetworkName;

    public SocialNetworksByName(String socialNetworkName) {
        this.socialNetworkName = socialNetworkName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.SOCIAL_NETWORKS_BY_NAME,
                socialNetworkName);
    }
}
