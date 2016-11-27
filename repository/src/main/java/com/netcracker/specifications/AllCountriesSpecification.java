package com.netcracker.specifications;

/**
 * Created by Yuksi on 27.11.2016.
 */
public class AllCountriesSpecification implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return "SELECT * FROM COUNTRIES";
    }
}
