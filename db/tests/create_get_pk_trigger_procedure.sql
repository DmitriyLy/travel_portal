CREATE OR REPLACE PROCEDURE CREATE_GET_PK_TRIGGER (param_tab_name IN VARCHAR2, param_pk_name IN VARCHAR2)
IS
  sql_stmt VARCHAR2(250);
  seq_name VARCHAR2(50);
  rec_count NUMBER := 0;
  trig_name VARCHAR2(100);
BEGIN

  seq_name := UPPER(param_tab_name) || '_SEQ';
  
  trig_name := 'GET_PK_' || UPPER(param_tab_name);
  
  SELECT
    COUNT(TRIGGER_NAME)
    INTO rec_count
  FROM
    USER_TRIGGERS
  WHERE
    TRIGGER_NAME = trig_name;
    
  IF rec_count > 0 THEN
    sql_stmt := 'DROP TRIGGER ' || trig_name;
    EXECUTE IMMEDIATE sql_stmt;
  END IF;
  
  sql_stmt := 'CREATE OR REPLACE TRIGGER ' || trig_name || ' BEFORE INSERT ON ' || UPPER(param_tab_name) || 
  ' FOR EACH ROW BEGIN :NEW.' || UPPER(param_pk_name) || 
  ' := ' || seq_name || '.NEXTVAL; END;';
  
  
  EXECUTE IMMEDIATE sql_stmt;
  
END;
/