DECLARE
  soc_net_id USERS.SOC_NET_ID%TYPE;
BEGIN

  SELECT
    ID
  INTO soc_net_id
  FROM
    SOCIAL_NETWORKS
  WHERE
    NAME = 'facebook.com';
    
  INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL, 'Ivan', 'Ivanov', 'ii123', soc_net_id, NULL);
  INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL, 'Petr', 'Petrov', 'pp456', soc_net_id, NULL);
  INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL, 'Sidor', 'Sidorov', 'ss456', soc_net_id, NULL);
  
  FOR i IN 1..10 LOOP
    INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL, 'User_facebook' || i, 'User_facebook' || i, 'uuF123' || ((i + 1) * 12), soc_net_id, NULL);
  END LOOP;
  
  SELECT
    ID
  INTO soc_net_id
  FROM
    SOCIAL_NETWORKS
  WHERE
    NAME = 'g+';
    
  FOR i IN 1..10 LOOP
    INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL, 'User_g_plus' || i, 'User_g_plus' || i, 'uuGplus123' || ((i + 1) * 12), soc_net_id, NULL);
  END LOOP;   
    
END;
/