package com.netcracker.controllers;

import com.netcracker.dto.LabelDtoShortInfo;
import com.netcracker.dto.SearchDtoParameters;
import com.netcracker.dto.SearchDtoTag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for search by different
 * parameters
 * Described in :
 * UC5 - Search labels in search window
 * UC7 - Search labels by tags
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
@RequestMapping("/search/by")
public class SearchController {

    /**
     * Method of search by any of the following parameters:
     *      category,
     *      geographical position,
     *      rating,
     *      tag.
     *
     * Method covers the following functional requirements:
     *      FR17 - The system should provide a search by labels
     *      FR18 - The system should provide a search by categories
     *      FR19 - The system should provide a search by geographic
     *          location (country, city, and so forth.)
     *      FR20 - The system should provide a search by rating
     *      FR21 - The system should provide a search by tag
     *
     * @param request {@link SearchDtoParameters} - object that contains full number
     *      of search parameters, any of which can be omitted.
     * @return List of {@link LabelDtoShortInfo} - list of objects that contain
     *      short information required for filtrating and searching labels on selected area.
     */
    @PostMapping("/parameters")
    public List<LabelDtoShortInfo> searchByFullRequest(@RequestBody SearchDtoParameters request) {
        return null;
    }

    /**
     * Method of search by tag
     *
     * Method covers the following functional requirements:
     *      FR29 - The system should provide a search by tag
     *
     * @param request {@link SearchDtoTag} - object that contains information about tag.
     * @return List of {@link LabelDtoShortInfo} - list of objects that contain
     *      short information required for filtrating and searching labels on selected area.
     */
    @GetMapping("/parameters/tag")
    public List<LabelDtoShortInfo> searchByTag(@RequestBody SearchDtoTag request) {
        return null;
    }
}