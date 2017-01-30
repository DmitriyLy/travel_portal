package com.netcracker.services.impl;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.entities.Location;
import com.netcracker.entities.User;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.services.CategoryService;
import com.netcracker.services.LabelService;
import com.netcracker.services.LocationService;
import com.netcracker.services.TagService;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;


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
    public Label update(Label label, LabelDtoUpdate labelDto) {
        if(label == null)
            return null;

        label.setRating(labelDto.getRating());
        label.setOwnerComment(labelDto.getReview());

        label = labelRepository.update(label);

        tagService.manageTags(label, labelDto.getTags());
        categoryService.manageCategories(label, labelDto.getCategories());

        return label;
    }

    @Override
    public void delete(Label label) {
        labelRepository.remove(label);
    }

    @Override
    public List<Label> getLabelsByUser(String userId) {
        return labelRepository.query(new LabelsByUser(userId));
    }

    @Override
    public List<Label> getLabelsCommentedByUser(String userId) {
        return labelRepository.query(new LabelsCommentedByUser(userId));
    }

    @Override
    public List<Label> getLabelsBookmarkedByUser(String userId) {
        return labelRepository.query(new LabelsBookmarkedByUser(userId));
    }

    @Override
    public List<Label> getLabelsByRectangle(SearchDtoRectangle rec) {
        return labelRepository.query(new LabelsOnAreaSpecification(rec.getBottomLeft().getLatitude(),
                                                                   rec.getTopRight().getLatitude(),
                                                                   rec.getTopRight().getLongitude(),
                                                                   rec.getBottomLeft().getLongitude()));
    }


    @Override
    public void addLabelToBookmarks(String userId, long labelId) {
        labelRepository.addLabelToBookmarks(userId, labelId);
    }

    @Override
    public void deleteLabelFromBookmarks(String userId, long labelId) {
        labelRepository.deleteLabelFromBookmarks(userId, labelId);
    }

    @Override
    public boolean isBookmarked(String userId, long labelId) {
        SqlSpecification specification = new CountBookmarkEntriesForUserAndLabelRENAME(userId,labelId);
        int count = jdbcTemplate.queryForObject(specification.toSqlQuery(), Integer.class);
        if (count == 0)
            return false;
        else if (count == 1)
            return true;
        else {
            //throw smth
        }
        return false;
    }
}
