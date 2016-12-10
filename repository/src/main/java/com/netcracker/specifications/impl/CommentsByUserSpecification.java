package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 11.12.2016.
 */
public class CommentsByUserSpecification implements SqlSpecification {
    private long userId;

    public CommentsByUserSpecification(long userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.COMMENTS_BY_USER_ID,
                userId
        );
    }
}
