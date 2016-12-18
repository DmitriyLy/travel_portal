package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Yuksi
 */
public class CommentsOnLabelSpecification implements SqlSpecification {
    private long labelId;

    public CommentsOnLabelSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.COMMENTS_BY_LABEL_ID,
                labelId
        );
    }
}
