package com.netcracker.specifications.impl;

import com.netcracker.entities.Category;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelsByCategories implements SqlSpecification {

    private String categoryIds;

    public LabelsByCategories(List<Category> categories) {
        this.categoryIds = SpecificationUtils.extractIdsAsString(categories);
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LABELS_BY_CATEGORIES,
                categoryIds
        );
    }
}
