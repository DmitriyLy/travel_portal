package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class LabelsByUser implements SqlSpecification {

    private String userId;

    public LabelsByUser(String userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LABELS_BY_USER,
                userId
        );
    }
}