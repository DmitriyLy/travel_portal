package com.netcracker.specifications.impl;

import com.netcracker.entities.Country;
import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 27.11.2016.
 */
public class StatesInCountrySpecification implements SqlSpecification {
    Country country;

    public StatesInCountrySpecification(Country country) {
        this.country = country;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.STATESBYCOUNTRYID,
                country.getId()
        );
    }
}
