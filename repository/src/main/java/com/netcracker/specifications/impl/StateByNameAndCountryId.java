package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class StateByNameAndCountryId implements SqlSpecification {

    private String stateName;
    private long countryId;

    public StateByNameAndCountryId(String stateName, long countryId) {
        this.stateName = stateName;
        this.countryId = countryId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.STATE_BY_NAME_AND_COUNTRY_ID,
                countryId,
                stateName
        );
    }
}
