connect / as sysdba;
@user_creation.sql
disconnect;
connect TRAVEL_PORTAL_TEST/TRAVEL_PORTAL_TEST
@drop_indexes.sql
@drop_tables_sequences.sql
@create_table_pk.sql
@create_sequences.sql
@add_references_fk.sql
@add_data_constraints.sql
@create_indexes.sql
COMMIT;
disconnect
connect / as sysdba;
GRANT CREATE ANY TRIGGER TO TRAVEL_PORTAL_TEST;
disconnect
connect TRAVEL_PORTAL_TEST/TRAVEL_PORTAL_TEST
--@create_get_pk_trigger_procedure.sql
--@create_pk_triggers.sql
--@create_stored_functions.sql
exit;
/