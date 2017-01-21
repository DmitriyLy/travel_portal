package com.netcracker.services;

import com.netcracker.dto.LabelDtoFullInfo;
import com.netcracker.dto.LabelDtoNew;
import com.netcracker.dto.LabelDtoShortInfo;
import com.netcracker.dto.LabelDtoUpdate;
import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;

import java.util.List;

/**
 *
 * @author logariett
 */
public interface LabelService {

    long getNewLabelId();

    Label add(String userId, LabelDtoNew labelDto);
    Label getById(long id);
    Label update(long labelId, LabelDtoUpdate labelDto);
    void delete(Label label);

/*    List<Label> getLabelsAll();
    List<Label> getLabelsByRectangle();
    List<Label> getLabelsByEllipse();
    List<Label> getLabelsByTag();
    List<Label> getLabelsBySearchRequest();*/

}
