package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CategoryByName implements SqlSpecification {

    private String categoryName;

    public CategoryByName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.CATEGORY_BY_NAME,
                categoryName
        );
    }
}
