package com.netcracker.services;

import com.netcracker.dto.*;
import com.netcracker.entities.*;

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

    CommentDtoInfo convertCommentToDtoInfo(Comment comment);

    AttachmentDtoInfo convertAttachmentToDtoInfo(Attachment attachment);
}
