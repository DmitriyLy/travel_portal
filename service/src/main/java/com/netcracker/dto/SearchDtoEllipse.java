package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class SearchDtoEllipse {

    private CoordinatesDto center;
    private double majorAxis;
    private double minorAxis;

    public CoordinatesDto getCenter() {
        return center;
    }

    public void setCenter(CoordinatesDto center) {
        this.center = center;
    }

    public double getMajorAxis() {
        return majorAxis;
    }

    public void setMajorAxis(double majorAxis) {
        this.majorAxis = majorAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
    }
}
