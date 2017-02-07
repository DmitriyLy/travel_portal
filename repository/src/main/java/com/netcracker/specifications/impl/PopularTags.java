package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by Yuksi on 07.02.2017.
 */
public class PopularTags implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.GET_POPULAR_TAGS);
    }
}
