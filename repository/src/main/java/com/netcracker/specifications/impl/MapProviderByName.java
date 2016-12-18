package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class MapProviderByName implements SqlSpecification {

    private String name;

    public MapProviderByName(String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.MAP_PROVIDER_BY_NAME, name);
    }
}
