package com.netcracker.repositories;

import com.netcracker.entities.Label;

import java.util.List;

/**
 * @author logariett.
 */
public interface LabelRepository extends IRepository<Label> {

    long getNewLabelId();

}
