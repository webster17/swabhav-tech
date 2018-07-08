USE aurionpro;

ALTER TABLE EMP
DROP CONSTRAINT EMP_SELF_KEY;

ALTER TABLE EMP
DROP CONSTRAINT EMP_PRIMARY_KEY;

CREATE CLUSTERED INDEX EMP_CUSTOM_CLUSTERED_INDEX
ON EMP(ENAME ASC, SAL DESC);

EXECUTE sp_helpindex EMP;

SELECT * FROM EMP;

DROP INDEX EMP_CUSTOM_CLUSTERED_INDEX ON EMP;

ALTER TABLE EMP
ADD CONSTRAINT EMP_PRIMARY_KEY PRIMARY KEY (EMPNO);

ALTER TABLE EMP
ADD CONSTRAINT EMP_SELF_KEY FOREIGN KEY (MGR) REFERENCES EMP(EMPNO);