package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by dima_2 on 11.12.2016.
 */
public class LabelTagsSpecification implements SqlSpecification {

    private long labelId;

    public LabelTagsSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.LABEL_TAGS, labelId);
    }
}
