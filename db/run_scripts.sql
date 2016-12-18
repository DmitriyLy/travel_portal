connect / as sysdba;
@user_creation.sql
disconnect;
connect TRAVEL_PORTAL/TRAVEL_PORTAL
@drop_indexes.sql
@drop_tables_sequences.sql
@create_table_pk.sql
@create_sequences.sql
@add_references_fk.sql
@add_data_constraints.sql
@create_indexes.sql
@insert_countries.sql
@insert_states.sql
@insert_cities.sql
@insert_soc_net.sql
@insert_categories.sql
@insert_tags.sql
@insert_users.sql
@insert_users2.sql
@insert_map_providers.sql
@insert_locations_labels_cat_tags.sql
@bookmarks_comments_attachments.sql
COMMIT;
disconnect
connect / as sysdba;
GRANT CREATE ANY TRIGGER TO TRAVEL_PORTAL;
disconnect
connect TRAVEL_PORTAL/TRAVEL_PORTAL
@create_get_pk_trigger_procedure.sql
@create_pk_triggers.sql
exit;
/