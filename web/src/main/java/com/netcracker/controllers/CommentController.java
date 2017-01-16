package com.netcracker.controllers;

import com.netcracker.dto.CommentDtoInfo;
import com.netcracker.dto.CommentDtoNew;
import com.netcracker.dto.CommentDtoUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The controller, whose methods provide ways of interacting with
 * an authorized user comments. It is worth noting that in
 * this controller is not the method getComment (), as the comments
 * received getFullLabelInfo perform () method of the class
 * {@link com.netcracker.controllers.LabelController}.
 *
 * This controller is responsible for:
 *      UC4 - Viewing label information.
 *      UC11 - Adding comments.
 *           - Editing comments.
 *      UC12 - Deleting comments.
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
@RequestMapping("/labels/{labelId}/comments")
public class CommentController {

    /*@Autowired
    CommentService commentService;*/

    /**
     * The method provides all comments under specified label.
     *
     * Method covers the following functional requirements:
     *      FR16 - The system should provide the ability to view comments.
     *
     * @param labelId - id of the label, comments to which should be provided.
     * @return list of {@link CommentDtoInfo} - objects, that contain information about existing comments.
     */
    @GetMapping
    public List<CommentDtoInfo> getCommentsByLabel(@PathVariable(name = "labelId") Long labelId) {
        return null;
    };

    /**
     * The method adds a comment to the mark left by the authorized user.
     *
     * Method covers the following functional requirements:
     *      FR42 - The system should provide the Authorized user to leave a comment for mark (revocation).
     *      FR43 - The system should provide the size limit comments to label (review) to 2000 characters.
     *      FR44 - The system should provide data storage for a comment to a label (review): comment, date created.
     *      FR45 - The system must provide a link to the comment tag (review) to leave it to authorized users.
     *
     * @param labelId - id of the label that is to be commented.
     * @param commentToAdd {@link CommentDtoNew} - object that contains information about comment to be added.
     * @return {@link CommentDtoInfo} - object, containing information about existing comment.
     */
    @PutMapping()
    public CommentDtoInfo addComment(@PathVariable(name = "labelId") Long labelId,
                           @RequestBody CommentDtoNew commentToAdd) {
        return null;
    };

    /**
     * Method of updating comment.
     *
     * Method covers the following functional requirements:
     *      FR42 - The system should provide the Authorized user to modify the comment to
     *          a label (review) for one hour from the time of creation.
     *
     * @param labelId - id of label, to which relates comment that is to be updated.
     * @param commentId - id of comment to update.
     * @param commentUpdate {@link CommentDtoUpdate} - object that contains information about comment update.
     * @return {@link CommentDtoInfo} - object, containing information about existing comment.
     */
    @PatchMapping("/{commentId}")
    public CommentDtoInfo editComment(@PathVariable(name = "labelId") Long labelId,
                                      @PathVariable(name = "commentId") Long commentId,
                                      @RequestBody CommentDtoUpdate commentUpdate) {
        return null;
    };

    /**
     * The controller is used to remove an authorized user comments.
     *
     * Method covers the following functional requirements:
     *      FR47 - The system should provide the Authorized user to delete the comment to a label (review).
     *
     * @param labelId - id of label, to which relates comment that is to be deleted.
     * @param commentId - id of comment needed to be deleted.
     */
    @DeleteMapping(value = "/{commentId}")
    public void deleteComment(@PathVariable(name = "labelId") Long labelId,
                              @PathVariable(name = "commentId") Long commentId) {

    };

}
