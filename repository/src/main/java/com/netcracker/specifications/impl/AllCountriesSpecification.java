package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Yuksi
 */
public class AllCountriesSpecification implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return QueriesSpecification.COUNTRIES_ALL;
    }
}
