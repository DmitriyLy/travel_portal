package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class CategoriesAll implements SqlSpecification {

    public CategoriesAll() {
    }

    @Override
    public String toSqlQuery() {
        return QueriesSpecification.CATEGORIES_ALL;
    }
}
