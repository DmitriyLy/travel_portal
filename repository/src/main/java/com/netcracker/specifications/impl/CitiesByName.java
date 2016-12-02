package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by dima_2 on 02.12.2016.
 */
public class CitiesByName implements SqlSpecification {

    private String cityName;

    public CitiesByName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.CITIES_BY_NAME, cityName);
    }
}
