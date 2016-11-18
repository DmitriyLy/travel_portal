DECLARE
  soc_net_id USERS.SOC_NET_ID%TYPE;
  f_user_count number(9);
BEGIN

  SELECT
    ID
  INTO soc_net_id
  FROM
    SOCIAL_NETWORKS
  WHERE
    NAME = 'facebook.com';
    
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Steven', 'King', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Neena', 'Kochhar', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Lex', 'De Haan', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alexander', 'Hunold', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Bruce', 'Ernst', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'David', 'Austin', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Valli', 'Pataballa', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Diana', 'Lorentz', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Nancy', 'Greenberg', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Daniel', 'Faviet', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'John', 'Chen', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Ismael', 'Sciarra', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jose Manuel', 'Urman', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Luis', 'Popp', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Den', 'Raphaely', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alexander', 'Khoo', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Shelli', 'Baida', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Sigal', 'Tobias', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Guy', 'Himuro', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Karen', 'Colmenares', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Matthew', 'Weiss', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Adam', 'Fripp', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Payam', 'Kaufling', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Shanta', 'Vollman', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Kevin', 'Mourgos', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Julia', 'Nayer', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Irene', 'Mikkilineni', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'James', 'Landry', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Steven', 'Markle', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Laura', 'Bissot', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Mozhe', 'Atkinson', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'James', 'Marlow', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'TJ', 'Olson', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jason', 'Mallin', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Michael', 'Rogers', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Ki', 'Gee', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Hazel', 'Philtanker', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Renske', 'Ladwig', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Stephen', 'Stiles', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'John', 'Seo', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Joshua', 'Patel', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Trenna', 'Rajs', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Curtis', 'Davies', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Randall', 'Matos', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Peter', 'Vargas', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);

  SELECT
    ID
  INTO soc_net_id
  FROM
    SOCIAL_NETWORKS
  WHERE
    NAME = 'g+';
    
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'John', 'Russell', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Karen', 'Partners', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alberto', 'Errazuriz', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Gerald', 'Cambrault', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Eleni', 'Zlotkey', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Peter', 'Tucker', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'David', 'Bernstein', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Peter', 'Hall', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Christopher', 'Olsen', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Nanette', 'Cambrault', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Oliver', 'Tuvault', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Janette', 'King', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Patrick', 'Sully', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Allan', 'McEwen', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Lindsey', 'Smith', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Louise', 'Doran', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Sarath', 'Sewall', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Clara', 'Vishney', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Danielle', 'Greene', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Mattea', 'Marvins', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'David', 'Lee', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Sundar', 'Ande', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Amit', 'Banda', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Lisa', 'Ozer', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Harrison', 'Bloom', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Tayler', 'Fox', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'William', 'Smith', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Elizabeth', 'Bates', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Sundita', 'Kumar', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Ellen', 'Abel', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alyssa', 'Hutton', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jonathon', 'Taylor', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jack', 'Livingston', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Kimberely', 'Grant', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Charles', 'Johnson', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Winston', 'Taylor', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jean', 'Fleaur', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Martha', 'Sullivan', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Girard', 'Geoni', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Nandita', 'Sarchand', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alexis', 'Bull', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Julia', 'Dellinger', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Anthony', 'Cabrio', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Kelly', 'Chung', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jennifer', 'Dilly', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Timothy', 'Gates', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Randall', 'Perkins', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Sarah', 'Bell', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Britney', 'Everett', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Samuel', 'McCain', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Vance', 'Jones', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Alana', 'Walsh', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Kevin', 'Feeney', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Donald', 'OConnell', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Douglas', 'Grant', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Jennifer', 'Whalen', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Michael', 'Hartstein', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Pat', 'Fay', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Susan', 'Mavris', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Hermann', 'Baer', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'Shelley', 'Higgins', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  INSERT INTO USERS VALUES (USERS_SEQ.NEXTVAL, 'William', 'Gietz', 'uuF123' || ((USERS_SEQ.NEXTVAL + 1) * 12), soc_net_id, NULL);
  
END;
/