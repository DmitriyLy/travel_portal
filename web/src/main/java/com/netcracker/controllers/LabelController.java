package com.netcracker.controllers;

import com.netcracker.DTO.CommentDTO;
import com.netcracker.DTO.FullLabelInfo;
import com.netcracker.DTO.LabelLocation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Controller for label
 * and related information extraction.
 * Described in :
 * UC4 - Label view; +
 * UC10 - Adding label to Bookmarks; +
 * UC13 - Lable creation; +
 * UC14 - Tag/category adding; +
 * UC15 - Review writing; +
 * UC16 - Rating adding; +
 * UC17 - Adding attachments; +
 * UC18 - Deleting attachments; +
 * UC19 - Label editing; +
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@Controller
@RequestMapping("/label")
public class LabelController {
    /**
     * Method of full label info extraction
     * by label id
     * Described in :
     * FR13 - The system should generate a window containing the following information:
     * • author's name,
     * • setup date,
     * • address,
     * • rating,
     * • review
     * • categories,
     * • a list of tags separated by commas,
     * • number of attachments
     * • number of comments
     *
     * @param labelId
     * @return FullLableInfo object
     */
    @RequestMapping(value = "/getFullLabelInfo", method = RequestMethod.GET)
    @ResponseBody
    public FullLabelInfo getFullLabelInfo(@RequestParam("labelId") Long labelId) {
        return null;
    }

    /**
     * Method of attachments extraction, depending on
     * which label id came from client
     * Described in:
     * FR14 - The system should provide the ability to view attachments;
     * FR15 - The system should provide display of attachments in accordance
     * with the order they are added to the label
     *
     * @param labelId
     * @return found attachments by label id
     */
    @RequestMapping(value = "/getAttachmentByLabelId", method = RequestMethod.GET)
    @ResponseBody
    public List<Byte[]> getAttachmentsByLabelId(@RequestParam("labelId") Long labelId) {
        return null;
    }

    /**
     * Method of comment extraction, depending on
     * which label id came from client
     * Described in:
     * FR16 - The system should provide the ability to view comments
     *
     * @param labelId
     * @return found text of comment by label id
     */
    @RequestMapping(value = "/getCommentByLabelId", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentDTO> getCommentsByLabelId(@RequestParam("labelId") Long labelId) {
        return null;
    }

    /**
     * Method of changing status of label
     * to favorite label
     * Described in:
     * FR39 - The system should allow the user to add a tag to favorites
     * FR41 - The system must provide a connection to the favorite labels by authorized user.
     *
     * @param labelId
     * @return status of adding to favorites
     */
    @RequestMapping(value = "/addLabelToFavorites", method = RequestMethod.POST)
    @ResponseBody
    public Integer addLabelToFavorites(@RequestParam("labelId") Long labelId) {
        return 0;
    }

    /**
     * Method of getting labels
     * from favorite scope
     * Described in:
     * FR40 - The system must provide storage of selected labels.
     * FR41 - The system must provide a connection to the favorite labels by authorized user.
     *
     * @return status of adding to favorites
     */
    @RequestMapping(value = "/getLabelsFromFavorites", method = RequestMethod.GET)
    @ResponseBody
    public List<FullLabelInfo> getLabelsFromFavorites() {
        return null;
    }

    /**
     * Method of deleting label
     * from favorite list
     * Described in:
     * nowhere
     *
     * @param labelId
     * @return status of deleting from favorites
     */
    @RequestMapping(value = "/deleteLabelFromFavorites", method = RequestMethod.POST)
    @ResponseBody
    public Integer deleteLabelFromFavorites(@RequestParam("labelId") Long labelId) {
        return 0;
    }

    /**
     * Method of adding label without
     * related data
     * Described in:
     * FR48 - The system should provide creating labels to authorized user.
     * FR49 - The system should carry out the positioning of the label and
     * return in form of categories an information about
     * the environment: country, region, city.
     *
     * @param location
     * @return status of adding label to database
     */
    @RequestMapping(value = "/addMarker", method = RequestMethod.POST)
    @ResponseBody
    public Integer addMarker(@RequestBody LabelLocation location) {
        return 0;
    }

    /**
     * Method of adding full lable info
     * to current label
     * Described in:
     * FR50 - The system should provide the authorized user to dynamically add tags to your label
     * FR52 - The system should provide the authorized user to select categories for your label.
     * FR54 - The system should provide the authorized user to post a review to his label.
     * FR56 - The system should provide the authorized user to specify label's rating.
     *
     * @param fullInfo
     * @return status of adding info about this.label
     */
    @RequestMapping(value = "/addMarkerData", method = RequestMethod.POST)
    @ResponseBody
    public Integer addMarkerData(@RequestBody FullLabelInfo fullInfo) {
        return 0;
    }

    /**
     * Method of deleting some tags
     * from label (or from everywhere)
     * Described in:
     * FR51 - The system should provide the authorized user to remove the tags from its label.
     *
     * @param idAndTags - labelId and array of tags
     * @return status of deleting tags from attachment(or from everywhere)
     */
    @RequestMapping(value = "/deleteTagsFromLabel", method = RequestMethod.POST)
    @ResponseBody
    public Integer deleteTagsFromLabel(@RequestBody FullLabelInfo idAndTags) {
        return 0;
    }

    /**
     * Method of adding attachment
     * to current label
     * Described in:
     * FR57 - The system should provide the authorized user the ability to attach files to their label.
     * FR59 - The system should provide adding file attachments from the user file system.
     *
     * @param attachment
     * @return status of adding attachment to this.label
     */
    @RequestMapping(value = "/addMarkerAttachment", method = RequestMethod.POST)
    @ResponseBody
    public Integer addMarkerAttachment(@RequestParam("attachment") MultipartFile attachment) {
        return 0;
    }

    /**
     * Method of deleting attachment
     * from current label
     * Described in:
     * FR61 - The system should provide the authorized user to remove attached file from their label.
     *
     * @param attachmentId
     * @return status of deleting attachment from database
     */
    @RequestMapping(value = "/deleteMarkerAttachment", method = RequestMethod.POST)
    @ResponseBody
    public Integer deleteMarkerAttachment(@RequestParam Long attachmentId) {
        return 0;
    }

    /**
     * Method of updating review information
     * for current label
     * Described in:
     * FR62 - The system should provide the ability to edit labels.
     * FR63 - The system should provide the ability to edit a review.
     *
     * @param idAndReview
     * @return status of updating label review
     */
    @RequestMapping(value = "/updateLabelReview", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateLabelReview(@RequestBody FullLabelInfo idAndReview) {
        return 0;
    }

    /**
     * Method of updating rating
     * for current label
     * Described in:
     * FR62 - The system should provide the ability to edit labels.
     * FR64 - The system should provide the ability to edit a rating.
     *
     * @param idAndRating
     * @return status of updating label rating
     */
    @RequestMapping(value = "/updateLabelRating", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateLabelRating(@RequestBody FullLabelInfo idAndRating) {
        return 0;
    }
}