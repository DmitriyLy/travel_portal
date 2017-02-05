package com.netcracker.specifications.impl;

import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.List;

/**
 * @author logariett.
 */
public class LabelFilterByTags implements SqlSpecification {

    private String tagIds;
    private String labelIds;

    public LabelFilterByTags(List<Tag> tags, List<Label> labels) {
        this.tagIds = SpecificationUtils.extractIdsAsString(tags);
        this.labelIds = SpecificationUtils.extractIdsAsString(labels);
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.FILTER_LABELS_BY_TAGS,
                tagIds,
                labelIds
        );
    }
}
