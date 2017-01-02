package com.netcracker.controllers;

import com.netcracker.DTO.CommentDTO;
import com.netcracker.DTO.LabelFilterInfo;
import com.netcracker.DTO.LabelLocation;
import com.netcracker.entities.FullLabelInfo;

import java.util.List;

/**
 * Controller for label
 * and related information extraction.
 * Described in :
 * UC4 - Label view;
 * UC10 - Adding label to Bookmarks
 * UC13 - Lable creation
 * UC14 - Tag/category adding
 * UC15 - Review writing
 * UC16 - Rating adding
 * UC17 - Adding attachments
 * UC18 - Deleting attachments
 * UC19 - Label editing
 * UC20 - Viewing own information
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */
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
    public FullLabelInfo getFullLabelInfo(long labelId) {
        return null;
    }

    /**
     * Method of attachment extraction, depending on
     * which label id came from client
     * Described in:
     * FR14 - The system should provide the ability to view attachments;
     * FR15 - The system should provide display of investments in accordance
     * with the order they are added to the label
     *
     * @param labelId
     * @return found attachment path by label id
     */
    public String getAttachmentByLabelId(long labelId) {
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
    public CommentDTO getCommentsByLabelId(long labelId) {
        return null;
    }

    public void addLabelToBookmark(long labelId){}

    public List<LabelFilterInfo> getLabelsFromBookmark(){
        return null;
    }

    public void deleteLabelFromBookmark(long labelId){}

    /**
     * Method of adding label without
     * related data
     * Described in:
     * FR48 - The system should provide the authorized user to create labels.
     * FR49 - The system should carry out the positioning of the label and
     * return in form of categories an information about
     * the environment: country, region, city.
     *
     * @param location
     */
    public void addMarker(LabelLocation location) {
    }

    /**
     * Method of adding full lable info
     * to current label
     * Described in:
     * FR48 - The system should provide the authorized user to create labels.
     * FR49 - The system should carry out the positioning of the label and
     * return in form of categories an information about
     * the environment: country, region, city.
     * @param fullInfo
     */
    public void addMarkerData(FullLabelInfo fullInfo) {
    }

    /**
     * Method of adding
     * Described in:
     *
     * @param
     * @return
     */
    public void addMarkerAttachment() {
    }

    /**
     * @param
     * @return
     */
    public void deleteMarkerAttachment() {
    }

    public void updateLabelReview(FullLabelInfo fullInfo){}

    public void updateLabelRating(FullLabelInfo labelId){}
}