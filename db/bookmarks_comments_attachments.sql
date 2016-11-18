INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('2.11.2016', 'DD.MM.YYYY'), '�������.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\7', '������ �����', '.png')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Kochhar' AND LABELS.OWNER_COMMENT = 'Opera theatre';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('3.11.2016', 'DD.MM.YYYY'), '�������� ���')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC9834', '����� ��������', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'De Haan' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('4.11.2016', 'DD.MM.YYYY'), '�����.')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC19874', '����� �����������', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Hunold' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('5.11.2016', 'DD.MM.YYYY'), '����� ���� �� ��� �����')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC98876', '������', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Ernst' AND LABELS.OWNER_COMMENT = 'Potemkin Stairs';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('6.11.2016', 'DD.MM.YYYY'), '����� ��������� ����?')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC4834', '�� ��������!!!', '.jpg')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Austin' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('7.11.2016', 'DD.MM.YYYY'), '�������� �������')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC94534', '������� ���', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Pataballa' AND LABELS.OWNER_COMMENT = 'Central Stadium Chernomorets';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('8.11.2016', 'DD.MM.YYYY'), '���� �� ������������� ��������� ���....:-)
��� �����������, ��������� ����� ����������!!!�����!!!')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC9854', '������� ���������', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Lorentz' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';
    
INSERT ALL  
  INTO BOOKMARKS VALUES(user_id, label_id)
  INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, user_id, label_id, TO_DATE('9.11.2016', 'DD.MM.YYYY'), '������� ���, ����� ���� ����� 3 ����, ���� ����������� �� ��� ������� �������')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC934', '����� �����', '.bmp')
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
  '������������) ����� �������� ����������� ��� ����� �����������) �������� ����� ��������, � ��� ��� ����� ����������� �� ��� � ��� ���� ���� ��� �� ����� ����� ��������, 
  � �� ������������ �� ������ ��� ������� � ��� �� ���) ��� ������� ���� ��� ���� �������� ����� ������� �� ����� 100��� � ������ ����� � ���������, ������ �� � � ��������� 
  ������� ���������) ������� �������')
  INTO ATTACHMENTS VALUES(ATTACHMENTS_SEQ.NEXTVAL, user_id, label_id, 'E:\foto\UC98324', '���� 1', '.bmp')
  SELECT
    USERS.ID AS user_id,
    LABELS.ID AS label_id
  FROM
    USERS, LABELS
  WHERE
    USERS.LAST_NAME = 'Faviet' AND LABELS.OWNER_COMMENT = 'Dolphinarium "Nemo"';