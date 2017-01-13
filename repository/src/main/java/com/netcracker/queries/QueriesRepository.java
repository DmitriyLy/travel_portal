package com.netcracker.queries;

/**
 * Basic CRUD queries
 *
 * @author Yuksi
 */
public interface QueriesRepository {
    String INSERT_COUNTRY = "INSERT INTO COUNTRIES(id,name) values(?,?)";
    String UPDATE_COUNTRY = "UPDATE COUNTRIES SET name=? WHERE id=?";
    String DELETE_COUNTRY = "DELETE FROM COUNTRIES WHERE id=?";
    String GET_COUNTRY_BY_ID = "SELECT * FROM COUNTRIES WHERE id=?";
    String GET_COUNT_OF_COUNTRIES = "SELECT count(*) FROM COUNTRIES";
    String GET_NEW_ID_COUNTRY = "SELECT COUNTRIES_SEQ.NEXTVAL FROM DUAL";

    String INSERT_STATE = "INSERT INTO STATES(id,country_id,name) values(?,?,?)";
    String UPDATE_STATE = "UPDATE STATES SET country_id=?, name=? WHERE id=?";
    String DELETE_STATE = "DELETE FROM STATES WHERE id=?";
    String GET_STATE_BY_ID = "SELECT * FROM STATES WHERE id=?";
    String GET_COUNT_OF_STATES = "SELECT count(*) FROM STATES";
    String GET_NEW_ID_STATES = "SELECT STATES_SEQ.NEXTVAL FROM DUAL";

    String INSERT_CITY = "INSERT INTO CITIES(id,state_id,name) values(?,?,?)";
    String UPDATE_CITY = "UPDATE CITIES SET state_id=?, name=? WHERE id=?";
    String DELETE_CITY = "DELETE FROM CITIES WHERE id=?";
    String GET_CITY_BY_ID = "SELECT * FROM CITIES WHERE id=?";
    String GET_COUNT_OF_CITIES = "SELECT count(*) FROM CITIES";
    String GET_NEW_ID_CITY = "SELECT CITIES_SEQ.NEXTVAL FROM DUAL";


    String INSERT_LOCATION = "INSERT INTO LOCATIONS(id,city_id,street,building) values(?,?,?,?)";
    String UPDATE_LOCATION = "UPDATE LOCATIONS SET city_id=?, street=?, building=? WHERE id=?";
    String DELETE_LOCATION = "DELETE FROM LOCATIONS WHERE id=?";
    String GET_LOCATION_BY_ID = "SELECT * FROM LOCATIONS WHERE id=?";
    String GET_COUNT_OF_LOCATIONS = "SELECT count(*) FROM LOCATIONS";
    String GET_NEW_ID_LOCATIONS = "SELECT LOCATIONS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_TAG = "INSERT INTO TAGS(id,name) values(?,?)";
    String UPDATE_TAG = "UPDATE TAGS SET name=? WHERE id=?";
    String DELETE_TAG = "DELETE FROM TAGS WHERE id=?";
    String GET_TAG_BY_ID = "SELECT * FROM TAGS WHERE id=?";
    String GET_COUNT_OF_TAGS = "SELECT count(*) FROM TAGS";
    String GET_NEW_ID_TAGS = "SELECT TAGS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_CATEGORY = "INSERT INTO CATEGORIES(id,name) values(?,?)";
    String UPDATE_CATEGORY = "UPDATE CATEGORIES SET name=? WHERE id=?";
    String DELETE_CATEGORY = "DELETE FROM CATEGORIES WHERE id=?";
    String GET_CATEGORY_BY_ID = "SELECT * FROM CATEGORIES WHERE id=?";
    String GET_COUNT_OF_CATEGORIES = "SELECT count(*) FROM CATEGORIES";
    String GET_NEW_ID_CATEGORY = "SELECT CATEGORIES_SEQ.NEXTVAL FROM DUAL";

    String INSERT_SOCIAL_NETWORK = "INSERT INTO SOCIAL_NETWORKS(id,name) values(?,?)";
    String UPDATE_SOCIAL_NETWORK = "UPDATE SOCIAL_NETWORKS SET name=? WHERE id=?";
    String DELETE_SOCIAL_NETWORK = "DELETE FROM SOCIAL_NETWORKS WHERE id=?";
    String GET_SOCIAL_NETWORK_BY_ID = "SELECT * FROM SOCIAL_NETWORKS WHERE id=?";
    String GET_COUNT_OF_NETWORKS = "SELECT count(*) FROM SOCIAL_NETWORKS";
    String GET_NEW_ID_SOCIAL_NETWORKS = "SELECT SOCIAL_NETWORKS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_USER = "INSERT INTO USERS(id,first_name,last_name,soc_net_user_id,soc_net_id,status) values(?,?,?,?,?,?)";
    String UPDATE_USER = "UPDATE USERS SET first_name=?, last_name=?, soc_net_user_id=?, soc_net_id=?, status=? WHERE id=?";
    String DELETE_USER = "DELETE FROM USERS WHERE id=?";
    String GET_USER_BY_ID = "SELECT * FROM USERS WHERE id=?";
    String GET_COUNT_OF_USERS = "SELECT count(*) FROM USERS";
    String GET_NEW_ID_USERS = "SELECT USERS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_MAP_PROVIDER = "INSERT INTO MAP_PROVIDERS(id,name,coord_sys_name) values(?,?,?)";
    String UPDATE_MAP_PROVIDER = "UPDATE MAP_PROVIDERS SET name=?, coord_sys_name=? WHERE id=?";
    String DELETE_MAP_PROVIDER = "DELETE FROM MAP_PROVIDERS WHERE id=?";
    String GET_MAP_PROVIDER_BY_ID = "SELECT * FROM MAP_PROVIDERS WHERE id=?";
    String GET_COUNT_OF_PROVIDERS = "SELECT count(*) FROM MAP_PROVIDERS";
    String GET_NEW_ID_MAP_PROVIDERS = "SELECT MAP_PROVIDERS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_COMMENT = "INSERT INTO COMMENTS(id,user_id,label_id,comment_date,comment_text) values(?,?,?,?,?)";
    String UPDATE_COMMENT = "UPDATE COMMENTS SET user_id=?, label_id=?, comment_date=?, comment_text=? WHERE id=?";
    String DELETE_COMMENT = "DELETE FROM COMMENTS WHERE id=?";
    String GET_COMMENT_BY_ID = "SELECT * FROM COMMENTS WHERE id=?";
    String GET_COUNT_OF_COMMENTS = "SELECT count(*) FROM COMMENTS";
    String GET_NEW_ID_COMMENT = "SELECT COMMENTS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_ATTACHMENT = "INSERT INTO ATTACHMENTS(id,user_id,label_id,file_path,name,extension) values(?,?,?,?,?,?)";
    String UPDATE_ATTACHMENT = "UPDATE ATTACHMENTS SET user_id=?, label_id=?, file_path=?, name=?, extension=? WHERE id=?";
    String DELETE_ATTACHMENT = "DELETE FROM ATTACHMENTS WHERE id=?";
    String GET_ATTACHMENT_BY_ID = "SELECT * FROM ATTACHMENTS WHERE id=?";
    String GET_COUNT_OF_ATTACHMENTS = "SELECT count(*) FROM ATTACHMENTS";
    String GET_NEW_ID_ATTACHMENT = "SELECT ATTACHMENTS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_LABEL = "INSERT INTO LABELS" +
            "(id,user_id,location_id,owner_comment,rating,coordinate_lat,coordinate_long,set_date,map_provider_id) " +
            "values(?,?,?,?,?,?,?,?,?)";
    String UPDATE_LABEL = "UPDATE LABELS SET " +
            "user_id=?, location_id=?, owner_comment=?, rating=?, coordinate_lat=?, coordinate_long=?, " +
            "set_date=?, map_provider_id=? WHERE id=?";
    String DELETE_LABEL = "DELETE FROM LABELS WHERE id=?";
    String GET_LABEL_BY_ID = "SELECT * FROM LABELS WHERE id=?";
    String GET_COUNT_OF_LABELS = "SELECT count(*) FROM LABELS";
    String GET_NEW_ID_LABELS = "SELECT LABELS_SEQ.NEXTVAL FROM DUAL";

    String INSERT_CONFIGURATION = "INSERT INTO CONFIGURATION(conf_key,conf_value) values(?,?)";
    String UPDATE_CONFIGURATION = "UPDATE CONFIGURATION SET conf_value=? WHERE conf_key=?";
    String DELETE_CONFIGURATION = "DELETE FROM CONFIGURATION WHERE conf_key=?";
    String GET_CONFIGURATION_BY_ID = "SELECT * FROM CONFIGURATION WHERE conf_key=?";
    String GET_COUNT_OF_CONFIGURATIONS = "SELECT count(*) FROM CONFIGURATION";
    String GET_NEW_ID_CONFIGURATION = "SELECT CONFIGURATION_SEQ.NEXTVAL FROM DUAL";
}
