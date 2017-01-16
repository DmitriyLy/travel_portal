package com.netcracker.services.impl;

import com.netcracker.entities.*;
import com.netcracker.repositories.impl.CategoryRepositoryImpl;
import com.netcracker.repositories.impl.FullLabelInfoRepositoryImpl;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.repositories.impl.TagRepositoryImpl;
import com.netcracker.services.IService;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.impl.LabelCategoriesSpecification;
import com.netcracker.specifications.impl.LabelTagsSpecification;
import com.netcracker.specifications.impl.LabelsOnAreaSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by dima_2 on 11.12.2016.
 */
@Service
//TODO - causes test fall
//@Transactional
public class LabelService implements IService<Label> {

    private final static Logger LOGGER = LogManager.getLogger(LabelService.class.getName());

    @Autowired
    private LabelRepositoryImpl labelRepository;
    @Autowired
    private CategoryRepositoryImpl categoryRepository;
    @Autowired
    private TagRepositoryImpl tagRepository;
    @Autowired
    private FullLabelInfoRepositoryImpl fullLabelInfoRepository;
    @Autowired
    private ObjectMapper jacksonObjectMapper;

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

    public List<Category> getLabelCategories(long labelId) {

        Specification specification = new LabelCategoriesSpecification(labelId);
        return categoryRepository.query(specification);
    }

    public List<Tag> getLabelTags(long labelId) {

        Specification specification = new LabelTagsSpecification(labelId);
        return tagRepository.query(specification);
    }

    public FullLabelInfo getFullLabelInfo(long labelId) {

        FullLabelInfo fullLabelInfo = fullLabelInfoRepository.getById(labelId);

        List<Category> categories = getLabelCategories(labelId);

        fullLabelInfo.setCategories(EntityOperations.getEntityNameList(categories));

        List<Tag> tags = getLabelTags(labelId);

        fullLabelInfo.setTags(EntityOperations.getEntityNameList(tags));

        return fullLabelInfo;
    }

    public String getFullLabelInfoJson(long labelId) {
        String resultJson = "";

        FullLabelInfo fullLabelInfo = getFullLabelInfo(labelId);

        try {
            resultJson = jacksonObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fullLabelInfo);
        } catch (JsonProcessingException e) {
            LOGGER.warn("Cannot create json for fullLabelInfo " + fullLabelInfo.toString());
        }

        return resultJson;
    }

    public FullLabelInfo getFullLabelInfoFromJson(String jsonText) {

        FullLabelInfo fullLabelInfo = null;

        try {
            fullLabelInfo = jacksonObjectMapper.readValue(jsonText, FullLabelInfo.class);
        } catch (IOException e) {
            LOGGER.warn("Cannot deserialize FullLabelInfo from JSON.");
        }

        return fullLabelInfo;
    }
}
