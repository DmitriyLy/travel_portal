DECLARE
  CURSOR table_list IS
    SELECT
      TABLE_NAME
    FROM
      USER_TAB_COLUMNS
    WHERE 
      COLUMN_NAME = 'ID';
    
  pk_column VARCHAR2(50) := 'ID';
  
BEGIN
  FOR table_list_rec IN table_list LOOP
    IF table_list_rec.table_name <> 'CONFIGURATION' THEN
      CREATE_GET_PK_TRIGGER(table_list_rec.table_name, pk_column);
    END IF;
  END LOOP;
END;
/