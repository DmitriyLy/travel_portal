package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class TagByName implements SqlSpecification {

    private String tagName;

    public TagByName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.TAG_BY_NAME,
                tagName
        );
    }
}
