package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Yuksi
 */
public class CommentsByUserSpecification implements SqlSpecification {
    private long userId;

    public CommentsByUserSpecification(long userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.COMMENTS_BY_USER_ID,
                userId
        );
    }
}
