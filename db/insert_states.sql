DECLARE
  country_id NUMBER;
BEGIN
SELECT
  id
INTO country_id
FROM
  COUNTRIES
WHERE
  name = 'Ukraine';
  
INSERT INTO STATES VALUES(STATES_SEQ.NEXTVAL, country_id, 'Odessa Oblast');
INSERT  INTO STATES VALUES(STATES_SEQ.NEXTVAL, country_id, 'Mykolaivs''ka oblast');
INSERT INTO STATES VALUES(STATES_SEQ.NEXTVAL, country_id, 'Kyivs''ka oblast');

END;
/