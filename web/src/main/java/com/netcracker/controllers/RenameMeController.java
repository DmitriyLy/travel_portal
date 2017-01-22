package com.netcracker.controllers;

import com.netcracker.entities.Category;
import com.netcracker.entities.Tag;
import com.netcracker.services.CategoryService;
import com.netcracker.services.Converter;
import com.netcracker.services.LabelService;
import com.netcracker.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett.
 */
@RestController
public class RenameMeController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/test")
    public List<Object> test() {
        List<Object> response = new ArrayList();

        return response;
    }

    /**
     * Method returns id, reserved for new label
     *
     * @return id.
     */
    @GetMapping("/reserveLabelId")
    public long reserveLabelId() {
        return labelService.getNewLabelId();
    }

    @GetMapping("/tags")
    public List<String> getAllTags() {
        List<Tag> tags = tagService.getAll();
        return tagService.extractTagNames(tags);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        return categoryService.extractCategoriesNames(categories);
    }

}
