package com.netcracker.controllers;

import com.netcracker.entities.FullLabelInfo;
import com.netcracker.entities.Label;

/**
 * Controller for search by different
 * parameters
 * Described in :
 * UC5 - Search labels in search window
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

public class SearchController {
    /**
     * Method of search by label name
     * Described in :
     * FR17 - The system should provide a search by labels
     *
     * @param labelName
     * @return Label object
     */
    public Label searchByLabelName(String labelName) {
        return null;
    }

    /**
     * Method of search by category
     * Described in :
     * FR18 - The system should provide a search by categories
     *
     * @param category
     * @return Label object
     */
    public Label searchByCategory(String category) {
        return null;
    }

    /**
     * Method of search by country, city
     * and so on...
     * Described in :
     * FR19 - The system should provide a search by geographic
     * location (country, city, and so forth.)
     * @param fullInfo
     * @return Label object
     */
    public Label searchByGeoLocation(FullLabelInfo fullInfo) {
        return null;
    }

    /**
     * Method of search by rating
     * Described in :
     * FR20 - The system should provide a search by rating
     * @param rating
     * @return Label object
     */
    public Label searchByRating(String rating) {
        return null;
    }

    /**
     * Method of search by tag
     * Described in :
     * FR21 - The system should provide a search by tag
     * @param tag
     * @return Label object
     */
    public Label searchByTag(String tag) {
        return null;
    }
}