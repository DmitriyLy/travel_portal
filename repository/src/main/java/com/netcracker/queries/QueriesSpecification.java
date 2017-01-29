package com.netcracker.queries;

/**
 * @author Yuksi
 */
public interface QueriesSpecification {
    String COUNTRIES_ALL = "SELECT * FROM COUNTRIES";
    String COUNTRY_BY_NAME = "SELECT * FROM COUNTRIES WHERE NAME = '%s'";

    String STATES_BY_COUNTRY_ID = "SELECT * FROM STATES WHERE COUNTRY_ID = %1$d";
    String STATES_BY_NAME = "SELECT * FROM STATES WHERE NAME = '%s'";
    String STATE_BY_NAME_AND_COUNTRY_ID = "SELECT * FROM STATES " +
            "WHERE COUNTRY_ID = %1$d AND NAME = '%2$s'";

    String CITIES_BY_NAME = "SELECT * FROM CITIES WHERE NAME = '%s'";
    String CITY_BY_NAME_AND_STATE_ID = "SELECT * FROM CITIES " +
            "WHERE STATE_ID = %1$d AND NAME = '%2$s'";

    String LOCATION_BY_CITY_ID_AND_STREET_AND_BUILDING = "SELECT * FROM LOCATIONS " +
            "WHERE CITY_ID = %1$d AND STREET = '%2$s' AND BUILDING = '%3$s'";

    String LABELS_BY_RECTANGLE = "SELECT * FROM LABELS WHERE COORDINATE_LAT >= %1$.7 AND " +
            "COORDINATE_LAT <= $2$.7 AND COORDINATE_LONG >= %3$.7 AND COORDINATE_LONG <= %4$.7";
    String LABELS_BY_USER = "SELECT * FROM LABELS WHERE USER_ID = '%s'";
    String LABELS_BOOKMARKED_BY_USER = "SELECT * FROM LABELS WHERE ID IN " +
            "(SELECT LABEL_ID FROM BOOKMARKS WHERE USER_ID = '%s')";
    String LABELS_COMMENTED_BY_USER = "SELECT * FROM LABELS WHERE ID IN " +
            "(SELECT LABEL_ID FROM COMMENTS WHERE USER_ID = '%s')";

    String ATTACHMENTS_BY_LABEL_ID = "SELECT * FROM ATTACHMENTS WHERE LABEL_ID = %1$d";
    String ATTACHMENT_BY_NAME_AND_LABEL_ID = "SELECT * FROM ATTACHMENTS " +
            "WHERE LABEL_ID = %1$d AND NAME = '%2$s'";
    String COMMENTS_BY_LABEL_ID = "SELECT * FROM COMMENTS WHERE LABEL_ID = %1$d";
    String CATEGORIES_BY_LABEL_ID = "SELECT * FROM CATEGORIES WHERE ID IN " +
            "(SELECT CATEGORY_ID FROM CATEGORIES_LABELS WHERE LABEL_ID = %1$d)";
    String TAGS_BY_LABEL_ID = "SELECT * FROM TAGS WHERE ID IN " +
            "(SELECT TAG_ID FROM TAGS_LABELS WHERE LABEL_ID = %1$d)";

    String ATTACHMENTS_COUNT_BY_LABEL_ID = "SELECT COUNT(*) FROM ATTACHMENTS WHERE LABEL_ID = %1$d";
    String COMMENTS_COUNT_BY_LABEL_ID = "SELECT COUNT(*) FROM COMMENTS WHERE LABEL_ID = %1$d";

    String TAGS_ALL = "SELECT * FROM TAGS";
    String TAG_BY_NAME = "SELECT * FROM TAGS WHERE NAME = '%s'";
    String TAG_USAGE_COUNT = "SELECT COUNT(*) FROM TAGS_LABELS WHERE TAG_ID = %1$d";

    String CATEGORIES_ALL = "SELECT * FROM CATEGORIES";
    String CATEGORY_BY_NAME = "SELECT * FROM CATEGORIES WHERE NAME = '%s'";

    String MAP_PROVIDER_BY_NAME = "SELECT * FROM MAP_PROVIDERS WHERE NAME = '%s'";

    String IS_BOOKMARKED_BY_USER_rename = "SELECT COUNT(*) FROM BOOKMARKS WHERE user_id = '%1$s' AND label_id = %2$d";
}
