package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 04.02.2017.
 */
public class LabelsByTagSpecification implements SqlSpecification {

    private String tagName;

    public LabelsByTagSpecification(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.LABELS_BY_TAG, tagName);
    }
}
