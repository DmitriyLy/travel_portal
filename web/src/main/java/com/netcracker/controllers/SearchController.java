package com.netcracker.controllers;

import com.netcracker.DTO.ShortLabelInfo;
import com.netcracker.DTO.SearchRequest;
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
@RequestMapping("/search")
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
     * @param request {@link com.netcracker.DTO.SearchRequest} - object that contains full number
     *                     of search parameters, any of which can be omitted
     * @return List of {@link ShortLabelInfo} - list of objects that contain
     *                     short information required for filtrating and searching labels on selected
     *                     area.
     */
    @PostMapping("/")
    public List<ShortLabelInfo> searchByFullRequest(@RequestBody SearchRequest request) {
        return null;
    }

    /**
     * Method of search by tag
     *
     * Method covers the following functional requirements:
     *      FR29 - The system should provide a search by tag
     *
     * @param tagName - string that contains name of the tag to search labels by
     * @return List of {@link ShortLabelInfo} - list of objects that contain
     *                     short information required for filtrating and searching labels on selected
     *                     area.
     */
    @GetMapping("/?tag={tagName}")
    public List<ShortLabelInfo> searchByTag(@PathVariable String tagName) {
        return null;
    }
}