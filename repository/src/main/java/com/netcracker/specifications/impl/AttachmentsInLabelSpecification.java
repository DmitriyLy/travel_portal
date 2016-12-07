package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by logariett on 07.12.16.
 */
public class AttachmentsInLabelSpecification implements SqlSpecification {

    private long labelId;

    public AttachmentsInLabelSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                IQueriesSpecification.ATTACHMENTS_BY_LABEL_ID,
                labelId);
    }
}
