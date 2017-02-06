package com.netcracker.specifications.impl;

import com.netcracker.entities.Category;
import com.netcracker.entities.Label;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelFilterByCategories implements SqlSpecification {

//    private String categoryIds;
    private String labelIds;
    private List<Long> categoryIds;

    public LabelFilterByCategories(List<Category> categories, List<Label> labels) {
//        this.categoryIds = SpecificationUtils.extractIdsAsString(categories);
        this.labelIds = SpecificationUtils.extractIdsAsString(labels);
        this.categoryIds = SpecificationUtils.extractIds(categories);
    }

    @Override
    public String toSqlQuery() {
        return SpecificationUtils.constructQueryLabelGetterByTagsOrCategories("category", categoryIds, labelIds);


/*        return String.format(
                QueriesSpecification.FILTER_LABELS_BY_CATEGORIES,
                categoryIds,
                labelIds
        );*/
    }
}
