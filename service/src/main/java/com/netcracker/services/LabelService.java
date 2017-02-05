package com.netcracker.services;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;
import com.netcracker.entities.User;

import java.util.List;

/**
 *
 * @author logariett
 */
public interface LabelService {

    long getNewLabelId();

    Label add(String userId, LabelDtoNew labelDto);
    Label update(Label label, LabelDtoUpdate labelDto);
    void delete(Label label);

    Label getById(long id);
    List<Label> getLabelsByUser(String userId);
    List<Label> getLabelsCommentedByUser(String userId);
    List<Label> getLabelsBookmarkedByUser(String userId);
    List<Label> getLabelsByRectangle(SearchDtoRectangle rec);
    List<Label> getLabelsByTag(String tagName);
    List<Label> getLabelsBySearchRequest(SearchDtoParameters request);

/*    List<Label> getLabelsByTags(List<String> tagNames);
    List<Label> getLabelsByCategories(List<String> categoryNames);
    List<Label> getLabelsByRatings(int[] ratings);
    List<Label> getLabelsByAddress(AddressDto addressDto);

    List<Label> filterLabelsByTags(List<String> tagNames, List<Label> labels);
    List<Label> filterLabelsByCategories(List<String> categoryNames, List<Label> labels);
    List<Label> filterLabelsByRatings(int[] ratings, List<Label> labels);
    List<Label> filterLabelsByAddress(AddressDto addressDto, List<Label> labels);*/

    void addLabelToBookmarks(String userId, long labelId);
    void deleteLabelFromBookmarks(String userId, long labelId);

/*    List<Label> getLabelsAll();
    List<Label> getLabelsByEllipse();
    List<Label> getLabelsBySearchRequest();*/

    boolean isBookmarked(String userId, long labelId);

}
