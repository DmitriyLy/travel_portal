connect / as sysdba;
@user_creation.sql
disconnect;
connect TRAVEL_PORTAL/TRAVEL_PORTAL
@drop_tables_sequences.sql
@create_table_pk.sql
@create_sequences.sql
@add_references_fk.sql
@add_data_constraints.sql
@insert_countries.sql
@insert_states.sql
@insert_cities.sql
@insert_soc_net.sql
@insert_categories.sql
@insert_tags.sql
@insert_users.sql
@insert_locations_labels_cat_tags.sql
COMMIT;
exit;
/