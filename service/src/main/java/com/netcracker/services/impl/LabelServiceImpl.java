package com.netcracker.services.impl;

import com.netcracker.dto.*;
import com.netcracker.entities.*;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.services.CategoryService;
import com.netcracker.services.LabelService;
import com.netcracker.services.LocationService;
import com.netcracker.services.TagService;
import com.netcracker.specifications.Specification;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Label> getLabelsByTag(String tagName) {
        return labelRepository.query(new LabelsByTagSpecification(tagName));
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
                                                                   rec.getBottomLeft().getLongitude(),
                                                                   rec.getTopRight().getLongitude()));
    }

    @Override
    public List<Label> getLabelsBySearchRequest(SearchDtoWithAddressParts request) {
        if (request == null)
            return null;

        List<Label> labels = new ArrayList<>();
        boolean dbCallWasMade = false;

        AddressPartsDto address = request.getAddress();
        List<String> entityNames;
        if (address != null) {
            entityNames = address.getPhrases();
            if (!isListNullOrEmptyOrOnlyNulls(entityNames)) {
                labels = getLabelsByAddressParts(entityNames);
                dbCallWasMade = true;
            }
        }

        entityNames = request.getTags();
        if (!isListNullOrEmptyOrOnlyNulls(entityNames))
            if (dbCallWasMade) {
                if (isListNullOrEmptyOrOnlyNulls(labels))
                    return new ArrayList<>(1);
                labels = filterLabelsByTags(entityNames, labels);
            } else {
                labels = getLabelsByTags(entityNames);
                dbCallWasMade = true;
            }

        entityNames = request.getCategories();
        if (!isListNullOrEmptyOrOnlyNulls(entityNames))
            if (dbCallWasMade) {
                if (isListNullOrEmptyOrOnlyNulls(labels))
                    return new ArrayList<>(1);
                labels = filterLabelsByCategories(entityNames, labels);
            } else {
                labels = getLabelsByCategories(entityNames);
                dbCallWasMade = true;
            }

        List<Integer> ratings = request.getRating();
        if(!isListNullOrEmptyOrOnlyNulls(ratings)) {
            if (dbCallWasMade) {
                if (isListNullOrEmptyOrOnlyNulls(labels))
                    return new ArrayList<>(1);
                labels = filterLabelsByRatings(ratings, labels);
            } else {
                labels = getLabelsByRatings(ratings);
                dbCallWasMade = true;
            }
        }

        /* quick fix */
        return labels;
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

    /************************************************/
    private List<Label> getLabelsByAddressParts(List<String> addressParts) {

        List<Label> labels = new ArrayList<>();

        if (addressParts.size() > 0) {
            Specification specification =  new LabelsByAddressPartsSpecification(addressParts);
            labels = labelRepository.query(specification);
        }

        return labels;
    }

    private List<Label> getLabelsByTags(List<String> tagNames) {
/*        if(isListNullOrEmptyOrOnlyNulls(tagNames))
            return null;*/

        List<Tag> tags = tagService.getByName(tagNames);
        if (tags == null)
            return null;

        return labelRepository.query(new LabelsByTags(tags));
    }


    private List<Label> getLabelsByCategories(List<String> categoryNames) {
/*        if(isListNullOrEmptyOrOnlyNulls(categoryNames))
            return null;*/

        List<Category> categories = categoryService.getByName(categoryNames);
        if (categories == null)
            return null;

        return labelRepository.query(new LabelsByCategories(categories));
    }


    private List<Label> getLabelsByRatings(List<Integer> ratings) {
/*        if(isListNullOrEmptyOrOnlyNulls(ratings))
            return null;*/

        return labelRepository.query(new LabelsByRatings(ratings));
    }


    private List<Label> getLabelsByAddress(AddressDto addressDto) {
        return null;
    }


    private List<Label> filterLabelsByTags(List<String> tagNames, List<Label> labels) {
/*        if(isListNullOrEmptyOrOnlyNulls(tagNames) || isListNullOrEmptyOrOnlyNulls(labels))
            return null;*/

        List<Tag> tags = tagService.getByName(tagNames);
        if (tags == null)
            return null;

        return labelRepository.query(new LabelFilterByTags(tags,labels));
    }


    private List<Label> filterLabelsByCategories(List<String> categoryNames, List<Label> labels) {
/*        if(isListNullOrEmptyOrOnlyNulls(categoryNames) || isListNullOrEmptyOrOnlyNulls(labels))
            return null;*/

        List<Category> categories = categoryService.getByName(categoryNames);
        if (categories == null)
            return null;

        return labelRepository.query(new LabelFilterByCategories(categories, labels));
    }


    private List<Label> filterLabelsByRatings(List<Integer> ratings, List<Label> labels) {
/*        if(isListNullOrEmptyOrOnlyNulls(ratings) || isListNullOrEmptyOrOnlyNulls(labels))
            return null;*/

        return labelRepository.query(new LabelFilterByRatings(ratings, labels));
    }

    private List<Label> filterLabelsByAddress(AddressDto addressDto, List<Label> labels) {
        return null;
    }

    private boolean isListNullOrEmptyOrOnlyNulls(List list){
        /* list probably shouldn't be changed within "isSomething" method */
        if(list == null)
            return true;
        else {
            list.removeIf(Objects::isNull);
            if (list.size() == 0)
                return true;
        }

        return false;
    }
}
