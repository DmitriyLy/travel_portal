package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class SearchDtoRectangle {

    private CoordinatesDto topLeft;
    private CoordinatesDto bottomRight;

    public CoordinatesDto getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(CoordinatesDto topLeft) {
        this.topLeft = topLeft;
    }

    public CoordinatesDto getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(CoordinatesDto bottomRight) {
        this.bottomRight = bottomRight;
    }
}
