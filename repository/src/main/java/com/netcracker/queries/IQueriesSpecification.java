package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesSpecification {
    String ALLCOUNTRIES = "SELECT * FROM COUNTRIES";
    String STATESBYCOUNTRYID = "SELECT * FROM STATES WHERE COUNTRY_ID = %1$d";
}
