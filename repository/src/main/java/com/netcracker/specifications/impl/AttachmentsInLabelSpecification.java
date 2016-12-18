package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Logariett
 */
public class AttachmentsInLabelSpecification implements SqlSpecification {

    private long labelId;

    public AttachmentsInLabelSpecification(long labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.ATTACHMENTS_BY_LABEL_ID,
                labelId);
    }
}
