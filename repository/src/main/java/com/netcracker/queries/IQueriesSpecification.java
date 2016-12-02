package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesSpecification {
    String ALL_COUNTRIES = "SELECT * FROM COUNTRIES";
    String STATES_BY_COUNTRY_ID = "SELECT * FROM STATES WHERE COUNTRY_ID = %1$d";
    String CITIES_BY_NAME = "SELECT * FROM CITIES WHERE NAME = '%s'";
}
