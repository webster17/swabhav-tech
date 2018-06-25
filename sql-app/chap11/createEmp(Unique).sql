CREATE TABLE Emp
 (empno      INT,
  name       VARCHAR(20),
  title      VARCHAR(20),
  CONSTRAINT   empno_pk     PRIMARY KEY (empno),
  CONSTRAINT   title_uk     UNIQUE (title))

