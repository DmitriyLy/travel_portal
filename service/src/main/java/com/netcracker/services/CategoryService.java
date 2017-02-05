package com.netcracker.services;

import com.netcracker.entities.Category;
import com.netcracker.entities.Label;

import java.util.List;

/**
 * @author logariett.
 */
public interface CategoryService {

    Category add(String categoryName);
    void delete(Category category);

    Category getById(long id);
    Category getByName(String categoryName);
    List<Category> getByName(List<String> categoryName);
    List<Category> getCategoriesByLabel(long labelId);
    List<Category> getAll();

    void manageCategories(Label label, List<String> updatedCategories);

    void bindLabelAndCategory(Label label, Category category);
    void unbindLabelAndCategory(Label label, Category category);

    List<String> extractCategoriesNames(List<Category> categories);

}
