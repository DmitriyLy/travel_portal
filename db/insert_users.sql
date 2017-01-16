DECLARE
  c_userid USERS.ID%TYPE;
  c_user_name USERS.user_name%TYPE;
  c_providerid USERCONNECTION.providerid%TYPE;
  c_provideruserid USERCONNECTION.provideruserid%TYPE;
  c_accesstoken USERCONNECTION.accesstoken%TYPE;
BEGIN
  
  c_userid := DBMS_RANDOM.STRING('A', 100);
  c_user_name := DBMS_RANDOM.STRING('A', 100);
  c_providerid := DBMS_RANDOM.STRING('A', 100);
  c_provideruserid := DBMS_RANDOM.STRING('A', 100);
  c_accesstoken := DBMS_RANDOM.STRING('A', 100);
  
  INSERT INTO USERS(id, user_name, first_name, last_name) VALUES(c_userid, c_user_name, 'Ivan', 'Ivanov');
  INSERT INTO USERCONNECTION(userid, providerid, provideruserid, accesstoken) VALUES(c_userid, c_providerid, c_provideruserid, c_accesstoken);
  
  c_userid := DBMS_RANDOM.STRING('A', 100);
  c_user_name := DBMS_RANDOM.STRING('A', 100);
  c_providerid := DBMS_RANDOM.STRING('A', 100);
  c_provideruserid := DBMS_RANDOM.STRING('A', 100);
  c_accesstoken := DBMS_RANDOM.STRING('A', 100);
  
  INSERT INTO USERS(id, user_name, first_name, last_name) VALUES(c_userid, c_user_name, 'Petr', 'Petrov');
  INSERT INTO USERCONNECTION(userid, providerid, provideruserid, accesstoken) VALUES(c_userid, c_providerid, c_provideruserid, c_accesstoken);
  
  c_userid := DBMS_RANDOM.STRING('A', 100);
  c_user_name := DBMS_RANDOM.STRING('A', 100);
  c_providerid := DBMS_RANDOM.STRING('A', 100);
  c_provideruserid := DBMS_RANDOM.STRING('A', 100);
  c_accesstoken := DBMS_RANDOM.STRING('A', 100);
  
  INSERT INTO USERS(id, user_name, first_name, last_name) VALUES(c_userid, c_user_name, 'Sidor', 'Sidorov');
  INSERT INTO USERCONNECTION(userid, providerid, provideruserid, accesstoken) VALUES(c_userid, c_providerid, c_provideruserid, c_accesstoken);
  
  FOR i IN 1..10 LOOP
    
    c_userid := DBMS_RANDOM.STRING('A', 100);
    c_user_name := DBMS_RANDOM.STRING('A', 100);
    c_providerid := DBMS_RANDOM.STRING('A', 100);
    c_provideruserid := DBMS_RANDOM.STRING('A', 100);
    c_accesstoken := DBMS_RANDOM.STRING('A', 100);
    
    INSERT INTO USERS(id, user_name, first_name, last_name) VALUES(c_userid, c_user_name, 'User_facebook' || i, 'User_facebook' || i);
    INSERT INTO USERCONNECTION(userid, providerid, provideruserid, accesstoken) VALUES(c_userid, c_providerid, c_provideruserid, c_accesstoken);
  END LOOP;
  
    
  FOR i IN 1..200 LOOP
    
    c_userid := DBMS_RANDOM.STRING('A', 100);
    c_user_name := DBMS_RANDOM.STRING('A', 100);
    c_providerid := DBMS_RANDOM.STRING('A', 100);
    c_provideruserid := DBMS_RANDOM.STRING('A', 100);
    c_accesstoken := DBMS_RANDOM.STRING('A', 100);
  
    INSERT INTO USERS(id, user_name, first_name, last_name) VALUES(c_userid, c_user_name, 'User_g_plus' || i, 'User_g_plus' || i);
    INSERT INTO USERCONNECTION(userid, providerid, provideruserid, accesstoken) VALUES(c_userid, c_providerid, c_provideruserid, c_accesstoken);
  END LOOP;   
    
END;
/