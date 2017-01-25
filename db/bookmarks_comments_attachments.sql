--
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('2.11.2016', 'DD.MM.YYYY'), 'Not bad.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test1.png')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Kochhar' AND LABELS.OWNER_COMMENT = 'Opera theatre';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('3.11.2016', 'DD.MM.YYYY'), 'Beautiful view')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id,'test2.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'De Haan' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('4.11.2016', 'DD.MM.YYYY'), 'Long.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test3.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Hunold' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('5.11.2016', 'DD.MM.YYYY'), 'The whole day ran on it')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test4.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Ernst' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('6.11.2016', 'DD.MM.YYYY'), 'When is the next game?')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test5.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Austin' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('7.11.2016', 'DD.MM.YYYY'), 'Nice stadium')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test6.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Pataballa' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('8.11.2016', 'DD.MM.YYYY'), 'We were at the presentation again .... :-)
I liked everything, a new interesting program !!! Super !!!')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id,'test7.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Lorentz' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('9.11.2016', 'DD.MM.YYYY'), 'Welcome tell if a child 3 years is free if made to pay')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id,'test8.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Greenberg' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('10.11.2016', 'DD.MM.YYYY'), 
  'ЗHello) yesterday posetyly us Delfynaryy Very ponravylos) delfynы Very Klassnyj and we Very ponravylos else is there something you have cafes where ìû Very sыtno pokushaly,
   if not pozavtrakat uspely speshyly way for you to show) everybody else sovetuyu This cafe conduct skupys shares in the amount of 100 UAH Receive a ticket terrarium, We in general and in the terrarium
   went free) thanks Bolshoi')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'test9.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Faviet' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';