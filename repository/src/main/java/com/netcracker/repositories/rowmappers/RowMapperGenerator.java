package com.netcracker.repositories.rowmappers;

/**
 * Created by Yuksi on 06.12.2016.
 */
public class RowMapperGenerator {

    public AttachmentRowMapper getAttachmentRowMapper() {
        return new AttachmentRowMapper();
    }

    public BookmarkRowMapper getBookmarkRowMapper() {
        return new BookmarkRowMapper();
    }

    public CategoryRowMapper getCategoryRowMapper() {
        return new CategoryRowMapper();
    }

    public CityRowMapper getCityRowMapper() {
        return new CityRowMapper();
    }

    public CommentRowMapper getCommentRowMapper() {
        return new CommentRowMapper();
    }

    public ConfigurationRowMapper getConfigurationRowMapper() {
        return new ConfigurationRowMapper();
    }

    public CountryRowMapper getCountryRowMapper() {
        return new CountryRowMapper();
    }

    public LabelRowMapper getLabelRowMapper() {
        return new LabelRowMapper();
    }

    public LocationRowMapper getLocationRowMapper() {
        return new LocationRowMapper();
    }

    public MapProviderRowMapper getMapProviderRowMapper() {
        return new MapProviderRowMapper();
    }

    public SocialNetworkRowMapper getSocialNetworkRowMapper() {
        return new SocialNetworkRowMapper();
    }

    public StateRowMapper getStateRowMapper() {
        return new StateRowMapper();
    }

    public TagRowMapper getTagRowMapper() {
        return new TagRowMapper();
    }

    public UserRowMapper getUserRowMapper() {
        return new UserRowMapper();
    }

    public FullLabelInfoRowMapper getFullLabelInfoRowMapper() {
        return new FullLabelInfoRowMapper();
    }
}
