CREATE TABLE Test2a
  (ssn       CHAR(9),
   salary    INT,
   CONSTRAINT ssn_salary_pk      PRIMARY KEY  (ssn, salary))

