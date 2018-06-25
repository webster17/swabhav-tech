CREATE TABLE Employee
  (empno   INT CONSTRAINT   empno_pk1 PRIMARY KEY,
   empname VARCHAR(20),
   dept    INT CONSTRAINT   dept_fk     REFERENCES   Department(deptno))

