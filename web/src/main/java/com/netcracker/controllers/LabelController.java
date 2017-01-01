package com.netcracker.controllers;

import com.netcracker.entities.Attachment;
import com.netcracker.entities.Comment;
import com.netcracker.entities.FullLabelInfo;

/**
 * Controller for label
 * and related information extraction.
 * Described in UC4
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */
public class LabelController {
    /**
     * Method of full label info extraction
     * Described in FR13
     * @param
     * @return FullLableInfo object
     */
    public FullLabelInfo getFullLabel() {
        return null;
    }
    /**
     * Method of attachment extraction, depending on
     * which label id came from client
     * Described in FR14,FR15
     * @param
     * @return found attachment by label id
     */
    public Attachment getAttachmentByLabelId() {
        return null;
    }
    /**
     * Method of comment extraction, depending on
     * which label id came from client
     * Described in FR16
     * @param
     * @return found comment by label id
     */
    public Comment getCommentsByLabelId() {
        return null;
    }
}
