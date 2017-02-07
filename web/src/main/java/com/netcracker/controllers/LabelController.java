package com.netcracker.controllers;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.entities.User;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import com.netcracker.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Controller for label
 * and related information extraction.
 * Described in :
 * UC4 - Label view; +
 * UC13 - Label creation; +
 * UC19 - Label editing; +
 *
 * @author Oveian Egor
 * @author Kozhuchar Alexander
 */

@RestController
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;
    @Autowired
    private Converter converter;

    /**
     * Method of adding a label.
     * <p>
     * Described in:
     * FR48 - The system should provide creating labels to authorized user.
     * FR49 - The system should carry out the positioning of the label and return in form of
     * categories an information about the environment: country, region, city.
     * FR50 - The system should provide the authorized user to dynamically add tags to your label
     * FR52 - The system should provide the authorized user to select categories for your label.
     * FR54 - The system should provide the authorized user to post a review to his label.
     * FR56 - The system should provide the authorized user to specify label's rating.
     *
     * @param labelToAdd {@link LabelDtoNew}
     * @return {@link LabelDtoShortInfo} - object, containing short information about label
     * that also allows filtering.
     */
    @PostMapping
    public LabelDtoFullInfo addLabel(@RequestBody LabelDtoNew labelToAdd) {
        //no validation or error handling yet
        User user = ControllerUtils.getUserFromContext();

        if (labelToAdd.getCreationDate() == null) {
            labelToAdd.setCreationDate(new Date());
        }
        if (user != null) {
            String loggedUserId = user.getId();

            Label label = labelService.add(loggedUserId, labelToAdd);
            return converter.convertLabelToDtoFullInfo(label);
        }

        return null;
    }

    /**
     * Method of full label info extraction by label id.
     * <p>
     * Described in :
     * FR13 - The system should generate a window containing the following information:
     * • author's name,
     * • setup date,
     * • address,
     * • rating,
     * • review
     * • categories,
     * • a list of tags separated by commas,
     * • number of attachments,
     * • number of comments.
     *
     * @param labelId
     * @return {@link LabelDtoFullInfo} - object, containing full information about label.
     */
    @GetMapping("/{labelId}")
    public LabelDtoFullInfo getLabelById(@PathVariable(name = "labelId") Long labelId) {
        Label label = labelService.getById(labelId);
        return converter.convertLabelToDtoFullInfo(label);
    }

    /**
     * Method of updating label's
     * • rating,
     * • review,
     * • categories,
     * • tags.
     * <p>
     * Described in:
     * FR62 - The system should provide the ability to edit labels.
     * FR63 - The system should provide the ability to edit a review.
     * FR64 - The system should provide the ability to edit a rating.
     *
     * @param labelUpdate {@link LabelDtoUpdate} - object that contains information
     *                    about label update.
     * @return {@link LabelDtoFullInfo} - object, containing full information about label.
     */
    @PatchMapping("/{labelId}")
    public LabelDtoFullInfo updateLabel(@PathVariable(name = "labelId") Long labelId,
                                        @RequestBody LabelDtoUpdate labelUpdate) {
        //no validation or error handling yet
        User user = ControllerUtils.getUserFromContext();

        if (user != null) {
            Label label = labelService.getById(labelId);
            String labelsOwnerId = label.getUserId();

            if (labelsOwnerId.equals(user.getId())) {
                label = labelService.update(label, labelUpdate);
                return converter.convertLabelToDtoFullInfo(label);
            } else {
                //throw smth
            }
        }

        return null;
    }

    @DeleteMapping("/{labelId}")
    public void deleteLabel(@PathVariable(name = "labelId") Long labelId) {
        User user = ControllerUtils.getUserFromContext();

        if (user != null) {
            Label label = labelService.getById(labelId);
            String labelsOwnerId = label.getUserId();

            if (labelsOwnerId.equals(user.getId())) {
                labelService.delete(label);

            } else {
                //throw smthng
            }
        }
    }

}