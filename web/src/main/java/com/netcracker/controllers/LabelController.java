package com.netcracker.controllers;

import com.netcracker.dto.*;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping
    public LabelDtoShortInfo addLabel(@RequestBody LabelDtoNew labelToAdd) {
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
        return null;
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
    public LabelDtoFullInfo updateLabelById(@RequestBody LabelDtoUpdate labelUpdate) {
        return null;
    }

}