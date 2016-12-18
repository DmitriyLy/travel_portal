package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class CitiesByName implements SqlSpecification {

    private String cityName;

    public CitiesByName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.CITIES_BY_NAME, cityName);
    }
}
