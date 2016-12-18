package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Logariett
 */
public class StatesByName implements SqlSpecification {

    private String stateName;

    public StatesByName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.STATES_BY_NAME, stateName);
    }
}
