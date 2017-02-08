package com.netcracker.controllers;

import com.netcracker.dto.LabelDtoMapInfo;
import com.netcracker.dto.LabelDtoShortInfo;
import com.netcracker.dto.SearchDtoEllipse;
import com.netcracker.dto.SearchDtoRectangle;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This controller is responsible for:
 * UC1 - View a map.
 * UC2 - The map zooms.
 * UC3 - View brief information about the tag.
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */
@Controller
public class MapController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private Converter converter;

    /**
     * Method returns start page to client.
     * Method covers the following functional requirements:
     * FR1 - The system must show the map.
     *
     * @return index.jsp
     */
    @GetMapping(value = "/")
    public String getMap(HttpSession session) {
        if(session.getAttribute("fallback_url")!=null){
            session.removeAttribute("fallback_url");
        }
        return "index";
    }

    /**
     * Method returns short label's info to client. It is required for setting labels on map.
     *
     * @param rectangle (@link SearchDtoRectangle} - object contains the coordinates of two points - NW and SE.
     *                  These points are determined by the system and form a straight line,
     *                  which is diagonal of rectangle. The points that are inside the
     *                  rectangle will be transmitted to the client.
     * @return List of {@link LabelDtoShortInfo} - list with objects that contains
     * short information required for setting labels on map.
     * <p>
     * Method covers the following functional requirements:
     * FR3 - When opening, the system must affix labels on the map.
     * FR4 - The system should display the number of labels that fall into the range of 1 cm,
     * a single cluster.
     * FR5 - The system should dynamically set the label as they enter the visible area during
     *  *          change the scale or display the geographical area.
     * FR6 - The system should hide the label coming out of the visible area or when you change
     * the scale of the displayed geographical area.
     * FR7 - The system should dynamically set the label as they enter the visible area when
     * changing the display scale or geographical area.
     * FR8 - The system should hide the label coming out of the visible area or when you change
     * the scale of the displayed geographical area.
     */
    @PostMapping("/labels/search/by/area/rectangle")
    @ResponseBody
    public List<LabelDtoMapInfo> getLabelsByRectangle(@RequestBody SearchDtoRectangle rectangle) {
        return labelService.getLabelsByRectangle(rectangle)
                .stream().map(a -> converter.convertLabelToDtoMapInfo(a))
                .collect(Collectors.toList());
    }
}
