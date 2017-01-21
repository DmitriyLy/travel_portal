package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CountryByName implements SqlSpecification {

    private String CountryName;

    public CountryByName(String cityName) {
        this.CountryName = cityName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.COUNTRY_BY_NAME,
                CountryName
        );
    }
}
