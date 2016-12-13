package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesRepository {
    String INSERT_COUNTRY = "INSERT INTO COUNTRIES(name) values(?)";
    String UPDATE_COUNTRY = "UPDATE COUNTRIES SET name=? WHERE id=?";
    String DELETE_COUNTRY = "DELETE FROM COUNTRIES WHERE id=?";
    String GET_COUNTRY_BY_ID = "SELECT * FROM COUNTRIES WHERE id=?";

    String INSERT_STATE = "INSERT INTO STATES(country_id,name) values(?,?)";
    String UPDATE_STATE = "UPDATE STATES SET country_id=?, name=? WHERE id=?";
    String DELETE_STATE = "DELETE FROM STATES WHERE id=?";
    String GET_STATE_BY_ID = "SELECT * FROM STATES WHERE id=?";

    String INSERT_CITY = "INSERT INTO CITIES(state_id,name) values(?,?)";
    String UPDATE_CITY = "UPDATE CITIES SET state_id=?, name=? WHERE id=?";
    String DELETE_CITY = "DELETE FROM CITIES WHERE id=?";
    String GET_CITY_BY_ID = "SELECT * FROM CITIES WHERE id=?";

    String INSERT_LOCATION = "INSERT INTO LOCATIONS(city_id,street,building) values(?,?,?)";
    String UPDATE_LOCATION = "UPDATE LOCATIONS SET city_id=?, street=?, building=? WHERE id=?";
    String DELETE_LOCATION = "DELETE FROM LOCATIONS WHERE id=?";
    String GET_LOCATION_BY_ID = "SELECT * FROM LOCATIONS WHERE id=?";

    String INSERT_TAG = "INSERT INTO SOCIAL_NETWORKS(name) values(?)";
    String UPDATE_TAG = "UPDATE SOCIAL_NETWORKS SET name=? WHERE id=?";
    String DELETE_TAG = "DELETE FROM SOCIAL_NETWORKS WHERE id=?";
    String GET_TAG_BY_ID = "SELECT * FROM SOCIAL_NETWORKS WHERE id=?";

    String INSERT_CATEGORY = "INSERT INTO CATEGORIES(name) values(?)";
    String UPDATE_CATEGORY = "UPDATE CATEGORIES SET name=? WHERE id=?";
    String DELETE_CATEGORY = "DELETE FROM CATEGORIES WHERE id=?";
    String GET_CATEGORY_BY_ID = "SELECT * FROM CATEGORIES WHERE id=?";

    String INSERT_SOCIAL_NETWORK = "INSERT INTO SOCIAL_NETWORKS(name) values(?)";
    String UPDATE_SOCIAL_NETWORK = "UPDATE SOCIAL_NETWORKS SET name=? WHERE id=?";
    String DELETE_SOCIAL_NETWORK = "DELETE FROM SOCIAL_NETWORKS WHERE id=?";
    String GET_SOCIAL_NETWORK_BY_ID = "SELECT * FROM SOCIAL_NETWORKS WHERE id=?";

    String INSERT_USER = "INSERT INTO USERS(first_name,last_name,soc_net_user_id,soc_net_id,status) values(?,?,?,?,?)";
    String UPDATE_USER = "UPDATE USERS SET first_name=?, last_name=?, soc_net_user_id=?, soc_net_id=?, status=? WHERE id=?";
    String DELETE_USER = "DELETE FROM USERS WHERE id=?";
    String GET_USER_BY_ID = "SELECT * FROM USERS WHERE id=?";

    String INSERT_MAP_PROVIDER = "INSERT INTO MAP_PROVIDERS(name,coord_sys_name) values(?,?)";
    String UPDATE_MAP_PROVIDER = "UPDATE MAP_PROVIDERS SET name=?, coord_sys_name=? WHERE id=?";
    String DELETE_MAP_PROVIDER = "DELETE FROM MAP_PROVIDERS WHERE id=?";
    String GET_MAP_PROVIDER_BY_ID = "SELECT * FROM MAP_PROVIDERS WHERE id=?";

    String INSERT_COMMENT = "INSERT INTO COMMENTS(user_id,label_id,comment_date,comment_text) values(?,?,?,?)";
    String UPDATE_COMMENT = "UPDATE COMMENTS SET user_id=?, label_id=?, comment_date=?, comment_text=? WHERE id=?";
    String DELETE_COMMENT = "DELETE FROM COMMENTS WHERE id=?";
    String GET_COMMENT_BY_ID = "SELECT * FROM COMMENTS WHERE id=?";

    String INSERT_ATTACHMENT = "INSERT INTO ATTACHMENTS(user_id,label_id,file_path,name,extension) values(?,?,?,?,?)";
    String UPDATE_ATTACHMENT = "UPDATE ATTACHMENTS SET user_id=?, label_id=?, file_path=?, name=?, extension=? WHERE id=?";
    String DELETE_ATTACHMENT = "DELETE FROM ATTACHMENTS WHERE id=?";
    String GET_ATTACHMENT_BY_ID = "SELECT * FROM ATTACHMENTS WHERE id=?";

    String INSERT_LABEL = "INSERT INTO LABELS" +
            "(user_id,location_id,owner_comment,rating,coordinate_lat,coordinate_long,set_date,map_provider_id) " +
            "values(?,?,?,?,?,?,?,?)";
    String UPDATE_LABEL = "UPDATE LABELS SET " +
            "user_id=?, location_id=?, owner_comment=?, rating=?, coordinate_lat=?, coordinate_long=?, " +
            "set_date=?, map_provider_id=? WHERE id=?";
    String DELETE_LABEL = "DELETE FROM LABELS WHERE id=?";
    String GET_LABEL_BY_ID = "SELECT * FROM LABELS WHERE id=?";

    String INSERT_BOOKMARK = "INSERT INTO BOOKMARKS(name) values(?)";
    String UPDATE_BOOKMARK = "UPDATE BOOKMARKS SET name=? WHERE id=?";
    String DELETE_BOOKMARK = "DELETE FROM BOOKMARKS WHERE id=?";
    String GET_BOOKMARK_BY_ID = "SELECT * FROM BOOKMARKS WHERE id=?";

    String INSERT_CONFIGURATION = "INSERT INTO CONFIGURATION(conf_key,conf_value) values(?,?)";
    String UPDATE_CONFIGURATION = "UPDATE CONFIGURATION SET conf_value=? WHERE conf_key=?";
    String DELETE_CONFIGURATION = "DELETE FROM CONFIGURATION WHERE conf_key=?";
    String GET_CONFIGURATION_BY_ID = "SELECT * FROM CONFIGURATION WHERE conf_key=?";

    String GET_FULL_LABEL_INFO_BY_ID = "SELECT\n" +
            "  LABELS.ID,\n" +
            "  USERS.FIRST_NAME || ' ' || USERS.LAST_NAME AS OWNER_NAME,\n" +
            "  TO_CHAR(LABELS.CREATION_DATE, 'DD.MM.YYYY HH24:MI:SS') AS CREATION_DATE,\n" +
            "  TO_CHAR(LABELS.COORDINATE_LAT) AS COORDINATE_LAT,\n" +
            "  TO_CHAR(LABELS.COORDINATE_LONG) AS COORDINATE_LONG,\n" +
            "  MAP_PROVIDERS.NAME AS MAP_PROVIDER,\n" +
            "  LOCATIONS.BUILDING,\n" +
            "  LABELS.STREET,\n" +
            "  CITIES.NAME AS CITY,\n" +
            "  STATES.NAME AS STATE,\n" +
            "  COUNTRIES.NAME AS COUNTRY\n" +
            "FROM\n" +
            "  LABELS, USERS, MAP_PROVIDERS, LOCATIONS, CITIES, STATES, COUNTRIES\n" +
            "WHERE\n" +
            "  LABELS.ID = ? AND LABELS.USER_ID = USERS.ID AND\n" +
            "  LABELS.MAP_PROVIDER_ID = MAP_PROVIDERS.ID AND LABELS.LOCATION_ID = LOCATIONS.ID AND\n" +
            "  LOCATIONS.CITY_ID = CITIES.ID AND CITIES.STATE_ID = STATES.ID AND\n" +
            "  STATES.COUNTRY_ID = COUNTRIES.ID;";
}
