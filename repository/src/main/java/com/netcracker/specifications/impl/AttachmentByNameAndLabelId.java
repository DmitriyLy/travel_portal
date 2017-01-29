package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by blaze159 on 29.01.17.
 */
public class AttachmentByNameAndLabelId implements SqlSpecification {

    private String attachName;
    private long labelId;

    public AttachmentByNameAndLabelId(String attachName, long labelId) {
        this.attachName = attachName;
        this.labelId = labelId;
    }

    @Override
    public String toSqlQuery() {
        return String.format(
                QueriesSpecification.ATTACHMENT_BY_NAME_AND_LABEL_ID,
                labelId,
                attachName
        );
    }
}