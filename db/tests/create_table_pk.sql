CREATE TABLE COUNTRIES (
  id NUMBER(4),
  name NVARCHAR2(200),
  CONSTRAINT pk_countries PRIMARY KEY (id)
);

CREATE TABLE STATES (
  id NUMBER(8),
  country_id NUMBER(4),
  name NVARCHAR2(200),
  CONSTRAINT pk_states PRIMARY KEY(id)
);

CREATE TABLE CITIES (
  id NUMBER(8),
  state_id NUMBER(8),
  name NVARCHAR2(200),
  CONSTRAINT pk_cities PRIMARY KEY (id)
);

CREATE TABLE LOCATIONS (
  id NUMBER(8),
  city_id NUMBER(8),
  street NVARCHAR2(200),
  building VARCHAR2(10),
  CONSTRAINT pk_locations PRIMARY KEY (id)
);

CREATE TABLE USERCONNECTION
(
	userid         VARCHAR2(255),
	providerid     VARCHAR2(255),
	provideruserid VARCHAR2(255),
	rank           INTEGER DEFAULT 0 NOT NULL,
	displayname    VARCHAR2(255),
	profileurl     VARCHAR2(512),
	imageurl       VARCHAR2(512),
	accesstoken    VARCHAR2(255) NOT NULL,
	secret         VARCHAR2(255),
	refreshtoken   VARCHAR2(255),
	expiretime     NUMBER(19),
	CONSTRAINT pk_userconn PRIMARY KEY(userid, providerid, provideruserid)
);

create table USERS
(
	id         VARCHAR2(255),
	email      VARCHAR2(100),
	user_name  NVARCHAR2(100) NOT NULL,
	first_name NVARCHAR2(100),
	last_name  NVARCHAR2(100),
	role       VARCHAR2(20) DEFAULT 'user' NOT NULL,
	enabled    VARCHAR2(1) DEFAULT 'Y' NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY (id)
) ;

CREATE TABLE LABELS (
  id NUMBER(10),
  user_id VARCHAR2(255),
  location_id NUMBER(8),
  owner_comment NVARCHAR2(500),
  rating NUMBER(1) DEFAULT 0,
  coordinate_lat NUMBER(12, 7),
  coordinate_long NUMBER(12, 7),
  creation_date DATE,
  map_provider_id NUMBER(5) NOT NULL,
  CONSTRAINT pk_labels PRIMARY KEY (id)
);

CREATE TABLE CATEGORIES (
  id NUMBER(4),
  name VARCHAR2(200),
  CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE TAGS (
  id NUMBER(9),
  name NVARCHAR2(500),
  CONSTRAINT pk_tags PRIMARY KEY (id)
);

CREATE TABLE BOOKMARKS (
  user_id VARCHAR2(255),
  label_id NUMBER(10),
  CONSTRAINT pk_bookmarks PRIMARY KEY (user_id, label_id)
);

CREATE TABLE COMMENTS (
  id NUMBER(11),
  user_id VARCHAR2(255),
  label_id NUMBER(10),
  comment_date DATE,
  comment_text NVARCHAR2(500),
  CONSTRAINT pk_comments PRIMARY KEY (id)
);

CREATE TABLE CATEGORIES_LABELS (
  label_id NUMBER(10),
  category_id NUMBER(4),
  CONSTRAINT pk_cat_labels PRIMARY KEY (label_id, category_id)
);

CREATE TABLE TAGS_LABELS (
  label_id NUMBER(10),
  tag_id NUMBER(9),
  CONSTRAINT pk_tags_labels PRIMARY KEY (label_id, tag_id)
);

CREATE TABLE ATTACHMENTS (
  id NUMBER(11),
  user_id VARCHAR2(255),
  label_id NUMBER(10),
  file_path VARCHAR2(250),
  name VARCHAR2(50),
  extension VARCHAR2(5),
  CONSTRAINT pk_attachements PRIMARY KEY (id)
);

CREATE TABLE MAP_PROVIDERS (
	id NUMBER(5),
	name NVARCHAR2(50),
	coord_sys_name NVARCHAR2(50),
	CONSTRAINT pk_map_providers PRIMARY KEY (id)	
);

CREATE TABLE CONFIGURATION (
	conf_key VARCHAR2(50),
	conf_value NVARCHAR2(250),
	CONSTRAINT pk_configuration PRIMARY KEY (conf_key)	
);