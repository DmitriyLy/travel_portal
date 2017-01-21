package com.netcracker.services.impl;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.entities.Location;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.services.CategoryService;
import com.netcracker.services.LabelService;
import com.netcracker.services.LocationService;
import com.netcracker.services.TagService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class LabelServiceImpl implements LabelService {
    private final static Logger LOGGER = LogManager.getLogger(LabelServiceImpl.class.getName());

    @Autowired
    private LabelRepositoryImpl labelRepository;
    @Autowired
    private LocationService locationService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;


    @Override
    public long getNewLabelId() {
        return labelRepository.getNewLabelId();
    }

    @Override
    @Transactional
    public Label add(String userId, LabelDtoNew labelDto) {
        Label label = new Label();

        label.setId(labelDto.getId());
        label.setUserId(userId);
        label.setCoordLat(labelDto.getCoordinates().getLatitude());
        label.setCoordLong(labelDto.getCoordinates().getLongitude());
        label.setOwnerComment(labelDto.getReview());
        label.setRating(labelDto.getRating());
        label.setCreationDate(labelDto.getCreationDate());
        /* it's google */
        label.setMapProviderId(1);

        Location location = locationService.getOrAdd(labelDto.getAddress());
        label.setLocationId(location.getId());

        label = labelRepository.add(label);

        tagService.manageTags(label, labelDto.getTags());
        categoryService.manageCategories(label, labelDto.getCategories());

        return label;
    }

    @Override
    public Label getById(long id) {
        return labelRepository.getById(id);
    }

    @Override
    @Transactional
    public Label update(long labelId, LabelDtoUpdate labelDto) {
        Label label = getById(labelId);

        label.setRating(labelDto.getRating());
        label.setOwnerComment(labelDto.getReview());

        label = labelRepository.update(label);

        tagService.manageTags(label, labelDto.getTags());
        categoryService.manageCategories(label, labelDto.getCategories());

        return label;
    }

    @Override
    public void delete(Label label) {

    }





}
