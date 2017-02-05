package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelsByRatings implements SqlSpecification {

    private String ratings;

    public LabelsByRatings(List<Integer> ratings) {
        this.ratings = SpecificationUtils.convertNumberArrayToString(ratings);
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LABELS_BY_RATINGS,
                ratings
        );
    }
}
