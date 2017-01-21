package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class TagsAll implements SqlSpecification {

    public TagsAll() {
    }

    @Override
    public String toSqlQuery() {
        return QueriesSpecification.TAGS_ALL;
    }
}
