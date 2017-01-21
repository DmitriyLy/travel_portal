package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CommentsCountByLabel implements SqlSpecification {

    private long labelId;

    public CommentsCountByLabel(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.COMMENTS_COUNT_BY_LABEL_ID,
                labelId
        );
    }
}