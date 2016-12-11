package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by dima_2 on 11.12.2016.
 */
public class MapProviderByName implements SqlSpecification {

    private String name;

    public MapProviderByName(String name) {
        this.name = name;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.MAP_PROVIDER_BY_NAME, name);
    }
}
