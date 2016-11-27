package com.netcracker.specifications;

import com.netcracker.entities.Country;

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
                "SELECT * FROM STATES WHERE COUNTRY_ID = %1$d",
                country.getId()
        );
    }
}
