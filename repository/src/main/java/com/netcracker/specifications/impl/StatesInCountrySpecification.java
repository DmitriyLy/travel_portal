package com.netcracker.specifications.impl;

import com.netcracker.entities.Country;
import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 27.11.2016.
 *
 * class for generating String query for searching states by country_id
 */
public class StatesInCountrySpecification implements SqlSpecification {
    private int countryId;

    public StatesInCountrySpecification(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.STATES_BY_COUNTRY_ID,
                countryId
        );
    }
}
