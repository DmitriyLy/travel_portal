DECLARE
  sql_stmt VARCHAR2(250);
  CURSOR table_list IS
    SELECT
      TABLE_NAME
    FROM
      USER_TAB_COLUMNS
    WHERE 
      COLUMN_NAME = 'ID';
    
  
  
BEGIN
  FOR table_list_rec IN table_list LOOP
    IF table_list_rec.table_name <> 'CONFIGURATION' THEN
      sql_stmt := 'CREATE OR REPLACE FUNCTION GET_NEW_ID_' || table_list_rec.table_name || ' RETURN NUMBER'
                  || ' IS BEGIN RETURN ' || table_list_rec.table_name || '_SEQ.NEXTVAL; END;';
                  
      DBMS_OUTPUT.put_line(sql_stmt);
      EXECUTE IMMEDIATE sql_stmt;
    END IF;
  END LOOP;
END;
/