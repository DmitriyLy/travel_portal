package com.netcracker.repositories;

import com.netcracker.entities.Label;

import java.util.List;

/**
 * @author logariett.
 */
public interface LabelRepository extends IRepository<Label> {

    long getNewLabelId();

    void addLabelToBookmarks(String userId, long labelId);
    void deleteLabelFromBookmarks(String userId, long labelId);

    void hardRemove(Label label);
}
