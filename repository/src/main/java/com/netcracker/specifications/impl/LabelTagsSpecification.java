package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class LabelTagsSpecification implements SqlSpecification {

    private long labelId;

    public LabelTagsSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.TAGS_BY_LABEL_ID, labelId);
    }
}
