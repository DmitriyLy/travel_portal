package com.netcracker.services.impl;

import com.netcracker.entities.Category;
import com.netcracker.entities.FullLabelInfo;
import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;
import com.netcracker.repositories.impl.CategoryRepositoryImpl;
import com.netcracker.repositories.impl.FullLabelInfoRepositoryImpl;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.repositories.impl.TagRepositoryImpl;
import com.netcracker.services.IService;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.impl.LabelCategoriesSpecification;
import com.netcracker.specifications.impl.LabelTagsSpecification;
import com.netcracker.specifications.impl.LabelsOnAreaSpecification;
import com.netcracker.specifications.impl.UserBookmarksSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dima_2 on 11.12.2016.
 */
@Service
@Transactional
public class LabelService implements IService<Label> {

    @Autowired
    private LabelRepositoryImpl labelRepository;
    @Autowired
    private CategoryRepositoryImpl categoryRepository;
    @Autowired
    private TagRepositoryImpl tagRepository;
    @Autowired
    private FullLabelInfoRepositoryImpl fullLabelInfoRepository;

    @Override
    public void save(Label item) {

    }

    @Override
    public void update(Label item) {

    }

    @Override
    public void delete(Label item) {

    }

    public List<Label> getLabelsOnArea(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {

        Specification specification = new LabelsOnAreaSpecification(minLatitude, maxLatitude, minLongitude,
                                                                                                maxLongitude);
        return labelRepository.query(specification);
    }

    public List<Label> getUserBookmarks(long userId) {

        Specification specification = new UserBookmarksSpecification(userId);
        return labelRepository.query(specification);
    }

    public List<Category> getLabelCategories(long labelId) {

        Specification specification = new LabelCategoriesSpecification(labelId);
        return categoryRepository.query(specification);
    }

    public List<Tag> getLabelTags(long labelId) {

        Specification specification = new LabelTagsSpecification(labelId);
        return tagRepository.query(specification);
    }

    public FullLabelInfo getFullLabelInfo(long labelId) {
        return fullLabelInfoRepository.getById(labelId);
    }

}
