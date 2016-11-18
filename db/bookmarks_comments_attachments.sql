INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('2.11.2016', 'DD.MM.YYYY'), 'Неплохо.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\7', 'Плохой актер', '.png')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Kochhar' AND LABELS.OWNER_COMMENT = 'Opera theatre';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('3.11.2016', 'DD.MM.YYYY'), 'Красивый вид')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC9834', 'Многа ступенек', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'De Haan' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('4.11.2016', 'DD.MM.YYYY'), 'Долго.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC19874', 'Долго поднимались', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Hunold' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('5.11.2016', 'DD.MM.YYYY'), 'Целый день по ней бегал')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC98876', 'Устали', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Ernst' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('6.11.2016', 'DD.MM.YYYY'), 'Когда следующая игра?')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC4834', 'МЫ ПОБЕДИЛИ!!!', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Austin' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('7.11.2016', 'DD.MM.YYYY'), 'Неплохой стадион')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC94534', 'Большой зал', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Pataballa' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('8.11.2016', 'DD.MM.YYYY'), 'Были на представлении очередной раз....:-)
Все понравилось, программа новая интересная!!!Супер!!!')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC9854', 'Веселая атмосфера', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Lorentz' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('9.11.2016', 'DD.MM.YYYY'), 'Доброго дня, кажіть якщо дитині 3 роки, вона безкоштовно чи теж потрібно платити')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC934', 'Много деток', '.bmp')
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
  'Здравствуйте) вчера посетили Дельфинарий нам очень понравилось) дельфины очень классные, а еще нам очень понравилось то что у вас есть кафе где мы очень сытно покушали, 
  а то позавтракать не успели так спешили к вам на шоу) еще советую всем это кафе проводит акцию скупись на сумму 100грн и получи билет в террариум, вообще мы и в террариум 
  сходили бесплатно) спасибо большое')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC98324', 'Фото 1', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Faviet' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';