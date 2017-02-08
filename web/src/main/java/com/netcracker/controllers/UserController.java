package com.netcracker.controllers;

import com.netcracker.dto.LabelDtoShortInfo;
import com.netcracker.entities.Label;
import com.netcracker.entities.User;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for user actions.
 * Described in :
 * UC10 - Adding label to Bookmarks; +
 * UC20 - Viewing personal information;
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private Converter converter;

    /**
     * Method of getting labels added by current user.
     *
     * Described in:
     * FR65 - The system must provide possibility to view labels added by user
     * as a part of personal information.
     *
     * @return List of {@link LabelDtoShortInfo} - list with objects that contains
     *                     short information required for setting labels on map.
     */
    @GetMapping("/me/labels/added")
    public List<LabelDtoShortInfo> getLabelsAddedByCurrentUser() {
        //no validation or error handling yet
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            List<Label> userLabels = labelService.getLabelsByUser(user.getUserId());
            List<LabelDtoShortInfo> labelShortDto = new ArrayList<>(userLabels.size());
            for (Label label : userLabels)
                labelShortDto.add(converter.convertLabelToDtoShortInfo(label));
            return labelShortDto;
        }
        return null;
    }

    /**
     * Method of getting labels that have been commented by current user.
     *
     * Described in:
     * FR66 - The system must provide possibility to view labels commented by current user
     * as a part of personal information.
     *
     * @return List of {@link LabelDtoShortInfo} - list with objects that contains
     *                     short information required for setting labels on map.
     */
    @GetMapping("/me/labels/commented")
    public List<LabelDtoShortInfo> getLabelsCommentedByCurrentUser() {
        //no validation or error handling yet
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            List<Label> commentedLabels = labelService.getLabelsCommentedByUser(user.getUserId());
            List<LabelDtoShortInfo> labelShortDto = new ArrayList<>(commentedLabels.size());
            for (Label label : commentedLabels)
                labelShortDto.add(converter.convertLabelToDtoShortInfo(label));
            return labelShortDto;
        }

        return null;
    }

    /**
     * Method of getting labels from favorite scope.
     *
     * Described in:
     * FR40 - The system must provide storage of selected labels.
     * FR41 - The system must provide a connection to the favorite labels by authorized user.
     *
     * @return List of {@link LabelDtoShortInfo} - list with objects that contains
     *                     short information required for setting labels on map.
     */
    @GetMapping("/me/labels/bookmarked")
    public List<LabelDtoShortInfo> getLabelsBookmarkedByCurrentUser() {
        //no validation or error handling yet
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            List<Label> bookmarkedLabels = labelService.getLabelsBookmarkedByUser(user.getUserId());
            List<LabelDtoShortInfo> labelShortDto = new ArrayList<>(bookmarkedLabels.size());
            for (Label label : bookmarkedLabels)
                labelShortDto.add(converter.convertLabelToDtoShortInfo(label));
            return labelShortDto;
        }
        return null;
    }

    /**
     * Method of changing status of label to favorite label.
     *
     * Described in:
     * FR39 - The system should allow the user to add a tag to favorites
     * FR41 - The system must provide a connection to the favorite labels by authorized user.
     *
     * @param labelId
     * @return status of adding to favorites
     */
    @GetMapping("/me/labels/bookmarked/{labelId}")
    public Integer addLabelToBookmarks(@PathVariable(name = "labelId") Long labelId) {
        //no validation or error handling yet
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            String userId = user.getId();
            boolean b = labelService.isBookmarked(userId, labelId);
            if (b)
                return 0;
            else {
                labelService.addLabelToBookmarks(user.getUserId(), labelId);
                return 1;
            }
        }
        return 0;
    }

    /**
     * Method of deleting label from favorite list.
     *
     * Described in:
     * nowhere
     *
     * @param labelId
     * @return status of deleting from favorites
     */
    @DeleteMapping("/me/labels/bookmarked/{labelId}")
    public Integer deleteLabelFromBookmarks(@PathVariable(name = "labelId") Long labelId) {
        //no validation or error handling yet
        User user = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (user != null) {
            if (labelService.isBookmarked(user.getUserId(), labelId)) {
                labelService.deleteLabelFromBookmarks(user.getUserId(), labelId);
                return 1;
            } else
                return 0;
        }

        return 0;
    }
}
