package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesSpecification {
    String ALL_COUNTRIES = "SELECT * FROM COUNTRIES";
    String STATES_BY_COUNTRY_ID = "SELECT * FROM STATES WHERE COUNTRY_ID = %1$d";
    String CITIES_BY_NAME = "SELECT * FROM CITIES WHERE NAME = '%s'";
    String STATES_BY_NAME = "SELECT * FROM STATES WHERE NAME = '%s'";
    String SOCIAL_NETWORKS_BY_NAME = "SELECT * FROM SOCIAL_NETWORKS WHERE NAME = '%s'";
    String ATTACHMENTS_BY_LABEL_ID = "SELECT * FROM ATTACHMENTS WHERE LABEL_ID = %1$d";
    String COMMENTS_BY_LABEL_ID = "SELECT * FROM COMMENTS WHERE LABEL_ID = %1$d";
    String COMMENTS_BY_USER_ID = "SELECT * FROM COMMENTS WHERE USER_ID = %1$d";
    String MAP_PROVIDER_BY_NAME = "SELECT * FROM MAP_PROVIDERS WHERE NAME = '%s'";
    String LABELS_ON_AREA = "SELECT * FROM LABELS WHERE COORDINATE_LAT >= %1$.7 AND " +
            "COORDINATE_LAT <= $2$.7 AND COORDINATE_LONG >= %3$.7 AND COORDINATE_LONG <= %4$.7";
    String USER_BOOKMARKS = "SELECT * FROM LABELS WHERE ID IN(SELECT LABEL_ID FROM " +
            "BOOKMARKS WHERE USER_ID = %1$d)";
    String LABEL_CATEGORIES = "SELECT * FROM CATEGORIES WHERE ID IN " +
            "(SELECT CATEGORY_ID FROM CATEGORIES_LABELS WHERE LABEL_ID = %1$d)";
    String LABEL_TAGS = "SELECT * FROM TAGS WHERE ID IN " +
            "(SELECT TAG_ID FROM TAGS_LABELS WHERE LABEL_ID = )";
}
