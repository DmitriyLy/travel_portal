package com.netcracker.specifications.impl;

import com.netcracker.entities.Label;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelFilterByRatings implements SqlSpecification {

    private String ratings;
    private String labelIds;

    public LabelFilterByRatings(List<Integer> ratings, List<Label> labels) {
        this.ratings = SpecificationUtils.convertNumberArrayToString(ratings);
        this.labelIds = SpecificationUtils.extractIdsAsString(labels);
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.FILTER_LABELS_BY_RATINGS,
                ratings,
                labelIds
        );
    }
}
