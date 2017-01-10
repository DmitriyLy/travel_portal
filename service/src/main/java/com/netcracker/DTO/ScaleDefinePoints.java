package com.netcracker.DTO;

/**
 * This object contains required data for scaling operations.
 *
 * @author Oveian Egor
 */

public class ScaleDefinePoints {
    private double neLatitude;
    private double neLongtitude;
    private double swLatitude;
    private double swLongtitude;

    public double getNeLatitude() {
        return neLatitude;
    }

    public void setNeLatitude(double neLatitude) {
        this.neLatitude = neLatitude;
    }

    public double getNeLongtitude() {
        return neLongtitude;
    }

    public void setNeLongtitude(double neLongtitude) {
        this.neLongtitude = neLongtitude;
    }

    public double getSwLatitude() {
        return swLatitude;
    }

    public void setSwLatitude(double swLatitude) {
        this.swLatitude = swLatitude;
    }

    public double getSwLongtitude() {
        return swLongtitude;
    }

    public void setSwLongtitude(double swLongtitude) {
        this.swLongtitude = swLongtitude;
    }
}
