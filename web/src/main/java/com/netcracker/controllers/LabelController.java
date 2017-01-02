package com.netcracker.controllers;

import com.netcracker.entities.Attachment;
import com.netcracker.entities.Comment;
import com.netcracker.entities.FullLabelInfo;

/**
 * Controller for label
 * and related information extraction.
 * Described in :
 * UC4 - Label view
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
    public FullLabelInfo getFullLabel(long labelId) {
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
     * @return found attachment by label id
     */
    public Attachment getAttachmentByLabelId(long labelId) {
        return null;
    }

    /**
     * Method of comment extraction, depending on
     * which label id came from client
     * Described in:
     * FR16 - The system should provide the ability to view comments
     *
     * @param labelId
     * @return found comment by label id
     */
    public Comment getCommentsByLabelId(long labelId) {
        return null;
    }

}
