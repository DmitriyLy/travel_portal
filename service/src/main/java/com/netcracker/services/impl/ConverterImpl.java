package com.netcracker.services.impl;

import com.netcracker.dto.*;
import com.netcracker.entities.*;
import com.netcracker.repositories.impl.UserDAO;
import com.netcracker.services.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett.
 */
@Service
public class ConverterImpl implements Converter {
    private final static Logger LOGGER = LogManager.getLogger(ConverterImpl.class.getName());

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LocationService locationService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AttachmentService attachmentService;



    @Override
    public LabelDtoFullInfo convertLabelToDtoFullInfo(Label label) {
        if (label == null)
            return null;

        LabelDtoFullInfo labelDto = new LabelDtoFullInfo();

        labelDto.setId(label.getId());
        labelDto.setRating(label.getRating());
        labelDto.setReview(label.getOwnerComment());
        labelDto.setCreationDate(label.getCreationDate());

        labelDto.setTags(convertLabelTagsToNamesArray(label.getId()));
        labelDto.setCategories(convertLabelCategoriesToNamesArray(label.getId()));
        labelDto.setCommentCount(commentService.getCommentCountByLabel(label.getId()));
        labelDto.setAttachments(attachmentService.getAttachmentsByLabel(label.getId()));

        User user = userDAO.findById(label.getUserId());
        labelDto.setOwner(convertUserToUserDtoInfo(user));

        //better as method
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLatitude(label.getCoordLat());
        coordinatesDto.setLongitude(label.getCoordLong());
        labelDto.setCoordinates(coordinatesDto);

        Location location = locationService.getById(label.getLocationId());
        labelDto.setAddress(convertLocationToAddressDto(location));

        return labelDto;
    }

    @Override
    public LabelDtoShortInfo convertLabelToDtoShortInfo(Label label) {
        if (label == null)
            return null;

        LabelDtoShortInfo labelDto = new LabelDtoShortInfo();

        //code duplicates fuuuu
        labelDto.setId(label.getId());
        labelDto.setRating(label.getRating());
        labelDto.setCreationDate(label.getCreationDate());

        labelDto.setTags(convertLabelTagsToNamesArray(label.getId()));
        labelDto.setCategories(convertLabelCategoriesToNamesArray(label.getId()));
        labelDto.setCommentCount(commentService.getCommentCountByLabel(label.getId()));
        labelDto.setAttachmentCount(attachmentService.getAttachmentCountByLabel(label.getId()));

        User user = userDAO.findById(label.getUserId());
        labelDto.setOwner(convertUserToUserDtoInfo(user));

        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLatitude(label.getCoordLat());
        coordinatesDto.setLongitude(label.getCoordLong());
        labelDto.setCoordinates(coordinatesDto);

        Location location = locationService.getById(label.getLocationId());
        labelDto.setAddress(convertLocationToAddressDto(location));

        return labelDto;
    }

    @Override
    public LabelDtoMapInfo convertLabelToDtoMapInfo(Label label) {
        if (label == null)
            return null;

        LabelDtoMapInfo labelDto = new LabelDtoMapInfo();

        labelDto.setId(label.getId());
        labelDto.setRating(label.getRating());
        labelDto.setCreationDate(labelDto.getCreationDate());

        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLatitude(label.getCoordLat());
        coordinatesDto.setLongitude(label.getCoordLong());
        labelDto.setCoordinates(coordinatesDto);

        return labelDto;
    }

    @Override
    public AddressDto convertLocationToAddressDto(Location location) {
        if (location == null)
            return null;

        AddressDto addressDto = new AddressDto();
        addressDto.setBuilding(location.getBuilding());
        addressDto.setStreet(location.getStreet());

        City city = cityService.getById(location.getCityId());
        if (city == null) {
            return null;
            //or throw smth
        }
        addressDto.setCity(city.getName());

        State state = stateService.getById(city.getStateId());
        if (state == null) {
            return null;
            //or throw smth
        }
        addressDto.setState(state.getName());

        Country country = countryService.getById(state.getCountryId());
        if (country == null) {
            return null;
            //or throw smth
        }
        addressDto.setCountry(country.getName());

        return addressDto;
    }

    @Override
    public UserDtoInfo convertUserToUserDtoInfo(User user) {
        if (user == null)
            return null;

        UserDtoInfo userDto = new UserDtoInfo();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        return userDto;
    }

    @Override
    public List<String> convertLabelTagsToNamesArray(long labelId) {
        List<Tag> tags = tagService.getTagsByLabel(labelId);
        List<String> tagNames = new ArrayList<>(tags.size());
        for (Tag tag : tags)
            tagNames.add(tag.getName());
        return tagNames;
    }

    @Override
    public List<String> convertLabelCategoriesToNamesArray(long labelId) {
        List<Category> categories = categoryService.getCategoriesByLabel(labelId);
        List<String> categoryNames = new ArrayList<>(categories.size());
        for (Category category : categories)
            categoryNames.add(category.getName());
        return categoryNames;
    }
}
