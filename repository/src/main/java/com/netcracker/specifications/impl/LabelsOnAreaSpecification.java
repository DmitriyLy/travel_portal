package com.netcracker.specifications.impl;

import com.netcracker.queries.QueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * @author Dmitriy Lysai
 */
public class LabelsOnAreaSpecification implements SqlSpecification {

    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;

    public LabelsOnAreaSpecification(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        this.minLatitude = Math.min(minLatitude, maxLatitude);
        this.maxLatitude = Math.max(minLatitude, maxLatitude);
        this.minLongitude = Math.min(minLongitude,maxLongitude);
        this.maxLongitude = Math.max(minLongitude,maxLongitude);
    }

    @Override
    public String toSqlQuery() {
        return String.format(QueriesSpecification.LABELS_BY_RECTANGLE, minLatitude, maxLatitude,
                minLongitude, maxLongitude);
    }
}
