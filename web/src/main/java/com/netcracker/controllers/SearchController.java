package com.netcracker.controllers;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/labels/search/by")
public class SearchController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private Converter converter;

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
    public List<LabelDtoShortInfo> searchByFullRequest(@RequestBody SearchDtoWithAddressParts request) {
        return converter.convertLabelToDtoShortInfo(labelService.getLabelsBySearchRequest(request));
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
        return converter.convertLabelToDtoShortInfo(labelService.getLabelsByTag(request.getTagName()));
    }

/*    *//**
     * Search by address parts
     *
     *//*
    @PostMapping("/parameters/addressparts")
    public List<LabelDtoShortInfo> searchByAddressParts(@RequestBody AddressPartsDto request) {
        return converter.convertLabelToDtoShortInfo(labelService.getLabelsByAddressParts(request.getPhrases()));
    }*/
}