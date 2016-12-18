package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Class for generating String query for searching states by country_id.
 *
 * @author Yuksi
 */
public class StatesInCountrySpecification implements SqlSpecification {
    private int countryId;

    public StatesInCountrySpecification(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.STATES_BY_COUNTRY_ID,
                countryId
        );
    }
}
