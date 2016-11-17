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
@insert_cities
exit;
/