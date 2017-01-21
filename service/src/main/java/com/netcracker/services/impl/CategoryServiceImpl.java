package com.netcracker.services.impl;

import com.netcracker.entities.Category;
import com.netcracker.entities.Label;
import com.netcracker.repositories.impl.CategoryRepositoryImpl;
import com.netcracker.services.CategoryService;
import com.netcracker.specifications.impl.CategoriesAll;
import com.netcracker.specifications.impl.CategoryByName;
import com.netcracker.specifications.impl.LabelCategoriesSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final static Logger LOGGER = LogManager.getLogger(CategoryServiceImpl.class.getName());

    @Autowired
    private CategoryRepositoryImpl categoryRepository;


    @Override
    public Category add(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        return categoryRepository.add(category);
    }

    @Override
    public Category getById(long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.remove(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.query(new CategoriesAll());
    }

    @Override
    public List<Category> getCategoriesByLabel(long labelId) {
        return categoryRepository.query(new LabelCategoriesSpecification(labelId));
    }

    @Override
    public Category getByName(String categoryName) {
        List<Category> categories = categoryRepository.query(new CategoryByName(categoryName));

        if (categories.size() == 0)
            return null;
        else if(categories.size() == 1)
            return categories.get(0);
        else {
            //throw smth
        }

        return null;
    }

    @Override
    public void manageCategories(Label label, List<String> updatedCategories) {
        if (label == null) {
            //throw smth
            return;
        }

        List<Category> labelCategories = getCategoriesByLabel(label.getId());

        if (labelCategories.size() == 0) {
            for (String categoryName : updatedCategories)
                addCategoryByNameToLabel(label, categoryName);

        } else if (updatedCategories == null || updatedCategories.size() == 0) {
            for (Category category : labelCategories)
                unbindLabelAndCategory(label, category);

        } else {
            for (Category category : labelCategories)
                if (updatedCategories.contains(category.getName()))
                    updatedCategories.remove(category.getName());
                else
                    unbindLabelAndCategory(label,category);

            for (String categoryName : updatedCategories)
                addCategoryByNameToLabel(label,categoryName);
        }
    }

    @Override
    public void bindLabelAndCategory(Label label, Category category) {
        categoryRepository.bindLabelAndCategory(label, category);
    }

    @Override
    public void unbindLabelAndCategory(Label label, Category category) {
        categoryRepository.unbindLabelAndCategory(label,category);
    }

    private void addCategoryByNameToLabel(Label label, String categoryName) {
        Category category = getByName(categoryName);
        if(category != null)
            bindLabelAndCategory(label,category);
        else {
            //log it
        }
    }
}
