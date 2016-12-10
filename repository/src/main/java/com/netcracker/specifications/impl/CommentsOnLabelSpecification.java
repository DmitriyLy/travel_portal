package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 11.12.2016.
 */
public class CommentsOnLabelSpecification implements SqlSpecification {
    private long labelId;

    public CommentsOnLabelSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.COMMENTS_BY_LABEL_ID,
                labelId
        );
    }
}
