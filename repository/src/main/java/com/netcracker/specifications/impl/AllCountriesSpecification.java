package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 27.11.2016.
 */
public class AllCountriesSpecification implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return IQueriesSpecification.ALL_COUNTRIES;
    }
}
