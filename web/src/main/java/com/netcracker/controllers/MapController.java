package com.netcracker.controllers;

import com.netcracker.DTO.LabelFilterInfo;
import com.netcracker.DTO.LabelMapInfo;
import com.netcracker.DTO.ScaleDefinePoints;
import com.netcracker.services.impl.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller is responsible for:
 *      UC1 - View a map.
 *      UC2 - The map zooms.
 *      UC3 - View brief information about the tag.
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */
@RestController
public class MapController {

    @Autowired
    LabelService labelService;

    /**
     * Method returns start page to client.
     * Method covers the following functional requirements:
     *      FR1 - The system must show the map.
     *
     * @return index.jsp
     */
    @GetMapping(value = "/")
    public String getMap() {
        return "index";
    }

    /**
     * Method returns short label's info to client. It is required for setting labels on map.
     *
     * @param definePoints - object contains the coordinates of two points - NE and SW.
     *                     These points are determined by the system and form a straight line,
     *                     which is diagonal of rectangle. The points that are inside the
     *                     rectangle will be transmitted to the client.
     * @return List of {@link com.netcracker.DTO.LabelMapInfo} - list with objects that contains
     *                     short information required for setting labels on map.
     *
     * Method covers the following functional requirements:
     *      FR3 - When opening, the system must affix labels on the map.
     *      FR4 - The system should display the number of labels that fall into the range of 1 cm,
     *          a single cluster.
     *      FR5 - The system should dynamically set the label as they enter the visible area during
     *          change the scale or display the geographical area.
     *      FR6 - The system should hide the label coming out of the visible area or when you change
     *          the scale of the displayed geographical area.
     *      FR7 - The system should dynamically set the label as they enter the visible area when
     *          changing the display scale or geographical area.
     *      FR8 - The system should hide the label coming out of the visible area or when you change
     *      the scale of the displayed geographical area.
     */
    @PostMapping(value = "/getLabelsByRect")
    public List<LabelMapInfo> getLabelsByRect(@RequestBody ScaleDefinePoints definePoints) {
        return null;
    }

    /**
     * Method returns short label's info to client. It is required for filtering and searching.
     *
     * @param definePoints - object contains the coordinates of two points. The coordinates of
     *                     the first point defined by the user, which indicates a random location
     *                     on the map. This point will be the center of the circle. The second
     *                     point defines the system. The distance between the first and the second
     *                     point will be the radius of the circle. The points that will be located
     *                     inside the circle will be transferred to the client.
     * @return List of {@link com.netcracker.DTO.LabelFilterInfo} - list with objects that contains
     *                     short information required for filtrating and searching labels on selected
     *                     area.
     *
     * Method covers the following functional requirements:
     *      FR10 - The system should create a list containing the summary and the hyperlink
     *          to view the information on the label.
     *      FR11 - The system should display the list (FR 10) in the top of the map window.
     *      FR12 - The system should allow you to sort the list (FR 10) rated / creation date labels.
     */
    @PostMapping(value = "/getLabelsByCircle")
    public List<LabelFilterInfo> getLabelsByCircle(@RequestBody ScaleDefinePoints definePoints) {
        return null;
    }

}
