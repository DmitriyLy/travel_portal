package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by logariett on 03.12.2016.
 */
public class StatesByName implements SqlSpecification {

    private String stateName;

    public StatesByName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.STATES_BY_NAME, stateName);
    }
}
