package com.netcracker.dto;

/**
 * @author logariett on 12.01.2017.
 */
public class SearchDtoRectangle {

    private CoordinatesDto topRight;
    private CoordinatesDto bottomLeft;

    public CoordinatesDto getTopRight() {
        return topRight;
    }

    public void setTopRight(CoordinatesDto topRight) {
        this.topRight = topRight;
    }

    public CoordinatesDto getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(CoordinatesDto bottomLeft) {
        this.bottomLeft = bottomLeft;
    }
}
