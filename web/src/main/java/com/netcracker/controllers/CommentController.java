package com.netcracker.controllers;

import com.netcracker.DTO.UserComment;
import com.netcracker.services.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The controller, which methods provide ways of interacting with
 * an authorized user comments labels. It is worth noting that in
 * this controller is not the method getComment (), as the comments
 * received getFullLabelInfo perform () method of the class
 * {@link com.netcracker.controllers.LabelController}.
 *
 * This controller is responsible for:
 *      UC11 - Adding comments.
 *      UC12 - Deleting comments.
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * The method adds a comment to the mark left by the authorized user.
     *
     * @param userComment - the object contains information about the user, who
     *                    wrote a commentary, information on the label, under which
     *                    was written comment, creation date, comments, and text
     *                    commentary.
     *
     * Method covers the following functional requirements:
     *      FR42 - The system should provide the Authorized user to leave a comment for mark (revocation).
     *      FR43 - The system should provide the size limit comments to label (review) to 2000 characters.
     *      FR44 - The system should provide data storage for a comment to a label (review): comment, date created.
     *      FR45 - The system must provide a link to the comment tag (review) to leave it to authorized users.
     */
    @PostMapping(value = "/addComment")
    public void addComment(@RequestBody UserComment userComment){};

    /**
     * The controller is used to remove an authorized user comments.
     *
     * @param commentId - id of comment you want to delete.
     *
     * Method covers the following functional requirements:
     *      FR47 - The system should provide the Authorized user to delete the comment to a label (review).
     */
    @PostMapping(value = "/delComment")
    public void deleteComment(@RequestBody Long commentId){};

    /**
     * Method returns short label's info to client. It is required for setting labels on map.
     *
     * @param userComment - the object contains information about the user, who
     *                    wrote a commentary, information on the label, under which
     *                    was written comment, creation date, comments, and text
     *                    commentary.
     *
     * Method covers the following functional requirements:
     *      FR42 - The system should provide the Authorized user to modify the comment to
     *                    a label (review) for one hour from the time of creation.
     */
    @PostMapping(value = "/editComment")
    public void editComment(@RequestBody UserComment userComment){};

}
