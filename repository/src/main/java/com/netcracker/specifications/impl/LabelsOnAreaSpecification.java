package com.netcracker.specifications.impl;

import com.netcracker.queries.IQueriesSpecification;
import com.netcracker.specifications.SqlSpecification;

/**
 * Created by dima_2 on 11.12.2016.
 */
public class LabelsOnAreaSpecification implements SqlSpecification {

    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;

    public LabelsOnAreaSpecification(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }

    @Override
    public String toSqlQuery() {
        return String.format(IQueriesSpecification.LABELS_ON_AREA, minLatitude, maxLatitude,
                minLongitude, maxLongitude);
    }
}
