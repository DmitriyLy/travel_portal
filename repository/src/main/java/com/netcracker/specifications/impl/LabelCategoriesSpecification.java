package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class LabelCategoriesSpecification implements SqlSpecification {

    private long labelId;

    public LabelCategoriesSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.LABEL_CATEGORIES, labelId);
    }
}
