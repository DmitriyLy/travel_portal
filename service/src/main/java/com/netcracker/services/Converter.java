package com.netcracker.services;

import com.netcracker.dto.*;
import com.netcracker.entities.Label;
import com.netcracker.entities.Location;
import com.netcracker.entities.User;

import java.util.List;

/**
 * @author logariett.
 */
public interface Converter {

    LabelDtoFullInfo convertLabelToDtoFullInfo(Label label);
    LabelDtoShortInfo convertLabelToDtoShortInfo(Label label);
    LabelDtoMapInfo convertLabelToDtoMapInfo(Label label);

    AddressDto convertLocationToAddressDto(Location location);
    UserDtoInfo convertUserToUserDtoInfo(User user);
    List<String> convertLabelTagsToNamesArray(long labelId);
    List<String> convertLabelCategoriesToNamesArray(long labelId);

}
