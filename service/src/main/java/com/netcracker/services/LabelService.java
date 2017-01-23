package com.netcracker.services;

import com.netcracker.dto.LabelDtoFullInfo;
import com.netcracker.dto.LabelDtoNew;
import com.netcracker.dto.LabelDtoShortInfo;
import com.netcracker.dto.LabelDtoUpdate;
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

    void addLabelToBookmarks(String userId, long labelId);
    void deleteLabelFromBookmarks(String userId, long labelId);

/*    List<Label> getLabelsAll();
    List<Label> getLabelsByRectangle();
    List<Label> getLabelsByEllipse();
    List<Label> getLabelsByTag();
    List<Label> getLabelsBySearchRequest();*/

    boolean isBookmarked(String userId, long labelId);

}
