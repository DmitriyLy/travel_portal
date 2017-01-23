package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CountBookmarkEntriesForUserAndLabelRENAME implements SqlSpecification {

    private String userId;
    private long labelId;

    public CountBookmarkEntriesForUserAndLabelRENAME(String userId, long labelId) {
        this.userId = userId;
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.IS_BOOKMARKED_BY_USER_rename,
                userId,
                labelId
        );
    }
}
