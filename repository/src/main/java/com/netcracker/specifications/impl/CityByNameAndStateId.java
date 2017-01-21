package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CityByNameAndStateId implements SqlSpecification {

    private String cityName;
    private long stateId;

    public CityByNameAndStateId(String cityName, long stateId) {
        this.cityName = cityName;
        this.stateId = stateId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.CITY_BY_NAME_AND_STATE_ID,
                stateId,
                cityName
        );
    }
}
