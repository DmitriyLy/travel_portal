package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class TagsUsageCount implements SqlSpecification {

    private long tagId;

    public TagsUsageCount(long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.TAG_USAGE_COUNT,
                tagId
        );
    }
}

