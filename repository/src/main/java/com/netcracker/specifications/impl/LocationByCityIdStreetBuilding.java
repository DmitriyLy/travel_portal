package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class LocationByCityIdStreetBuilding implements SqlSpecification {

    private String street;
    private String building;
    private long cityId;

    public LocationByCityIdStreetBuilding(long cityId, String street, String building) {
        this.street = street;
        this.building = building;
        this.cityId = cityId;
    }


    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LOCATION_BY_CITY_ID_AND_STREET_AND_BUILDING,
                cityId,
                street,
                building
        );
    }
}
