package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author logariett.
 */
public class AttachmentsCountByLabel implements SqlSpecification {

    private long labelId;

    public AttachmentsCountByLabel(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.ATTACHMENTS_COUNT_BY_LABEL_ID,
                labelId
        );
    }
}
