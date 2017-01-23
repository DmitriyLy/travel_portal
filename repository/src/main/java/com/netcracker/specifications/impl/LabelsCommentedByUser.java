package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class LabelsCommentedByUser implements SqlSpecification {

    private String userId;

    public LabelsCommentedByUser(String userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LABELS_COMMENTED_BY_USER,
                userId
        );
    }
}
