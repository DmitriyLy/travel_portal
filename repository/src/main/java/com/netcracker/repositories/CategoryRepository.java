package com.netcracker.repositories;

import com.netcracker.entities.Category;
import com.netcracker.entities.Label;

/**
 * @author logariett.
 */
public interface CategoryRepository extends IRepository<Category> {

    void bindLabelAndCategory(Label label, Category category);
    void unbindLabelAndCategory(Label label, Category category);

}
