package com.netcracker.specifications.impl;

import com.netcracker.entities.Tag;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelsByTags implements SqlSpecification {

    private String tagIds;

    public LabelsByTags(List<Tag> tags) {
        this.tagIds = SpecificationUtils.extractIdsAsString(tags);
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.LABELS_BY_TAGS,
                tagIds
        );
    }
}
