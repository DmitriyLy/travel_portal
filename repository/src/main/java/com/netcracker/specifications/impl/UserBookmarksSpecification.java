package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by dima_2 on 11.12.2016.
 */
public class UserBookmarksSpecification implements SqlSpecification {

    private long userId;

    public UserBookmarksSpecification(long userId) {
        this.userId = userId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.USER_BOOKMARKS, userId);
    }
}
