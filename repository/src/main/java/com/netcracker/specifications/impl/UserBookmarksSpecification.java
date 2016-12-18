package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class UserBookmarksSpecification implements SqlSpecification {

    private long userId;

    public UserBookmarksSpecification(long userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.USER_BOOKMARKS, userId);
    }
}
