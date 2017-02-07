package com.netcracker.specifications.impl;

import com.netcracker.entities.Tag;
import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.utils.SpecificationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author logariett.
 */
public class LabelsByTags implements SqlSpecification {

//    private String tagIdsStr;
    private List<Long> tagIds;

    public LabelsByTags(List<Tag> tags) {
//        this.tagIdsStr = SpecificationUtils.extractIdsAsString(tags);

        this.tagIds = SpecificationUtils.extractIds(tags);
    }

    @Override
    public String toSqlQuery() {
        return SpecificationUtils.constructQueryLabelGetterByTagsOrCategories("tag", tagIds, null);

/*        return String.format(
                QueriesSpecification.LABELS_BY_TAGS,
                tagIdsStr
        );*/
    }
}
