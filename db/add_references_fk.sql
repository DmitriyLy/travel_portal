ALTER TABLE STATES ADD CONSTRAINT country_id_ref
FOREIGN KEY(country_id) REFERENCES countries(id);

ALTER TABLE CITIES ADD CONSTRAINT state_id_ref
FOREIGN KEY(state_id) REFERENCES states(id);

ALTER TABLE LOCATIONS ADD CONSTRAINT city_id_ref
FOREIGN KEY(city_id) REFERENCES cities(id);

--ALTER TABLE USERS ADD CONSTRAINT soc_net_id_ref
--FOREIGN KEY(soc_net_id) REFERENCES SOCIAL_NETWORKS(id);

ALTER TABLE LABELS ADD CONSTRAINT label_user_id_ref
FOREIGN KEY(user_id) REFERENCES USERS(id);

ALTER TABLE LABELS ADD CONSTRAINT label_location_id_ref
FOREIGN KEY(map_provider_id) REFERENCES MAP_PROVIDERS(id);

ALTER TABLE LABELS ADD CONSTRAINT map_provider_id_ref
FOREIGN KEY(location_id) REFERENCES locations(id);

ALTER TABLE ATTACHMENTS ADD CONSTRAINT attch_label_id_ref
FOREIGN KEY(label_id) REFERENCES LABELS(id);

ALTER TABLE BOOKMARKS ADD CONSTRAINT bookm_label_id_ref
FOREIGN KEY(label_id) REFERENCES LABELS(id);

ALTER TABLE BOOKMARKS ADD CONSTRAINT bookm_user_id_ref
FOREIGN KEY(user_id) REFERENCES USERS(id);

ALTER TABLE COMMENTS ADD CONSTRAINT comment_user_id_ref
FOREIGN KEY(user_id) REFERENCES USERS(id);

ALTER TABLE COMMENTS ADD CONSTRAINT comment_label_id_ref
FOREIGN KEY(label_id) REFERENCES LABELS(id);

ALTER TABLE CATEGORIES_LABELS ADD CONSTRAINT cat_lab_label_id_ref
FOREIGN KEY(label_id) REFERENCES LABELS(id);

ALTER TABLE CATEGORIES_LABELS ADD CONSTRAINT cat_lab_category_id_ref
FOREIGN KEY(category_id) REFERENCES CATEGORIES(id);

ALTER TABLE TAGS_LABELS ADD CONSTRAINT tag_lab_label_id_ref
FOREIGN KEY(label_id) REFERENCES LABELS(id);

ALTER TABLE TAGS_LABELS ADD CONSTRAINT tag_lab_tag_id_ref
FOREIGN KEY(tag_id) REFERENCES TAGS(id);