USE aurionpro;

-- FIRST CREATE LOG TABLE
CREATE TABLE EMP_LOG (
 EMPNO               INTEGER NOT NULL,
 ENAME               VARCHAR(10),
 JOB                 VARCHAR(9),
 MGR                 INTEGER,
 HIREDATE            DATETIME,
 SAL                 MONEY,
 COMM                MONEY,
 DEPTNO              INTEGER,
 UPDATE_DATE		DATETIME DEFAULT GETDATE()
 );
 
-- CREATE PROCEDURE FUNCTION TO MAKE LOG ON EACH UPDATE
CREATE PROCEDURE aurionpro.empLogInfo
(
	@EMPNO INT
)
AS
BEGIN
INSERT INTO EMP_LOG(
	EMPNO, 
	ENAME,
	JOB,
	MGR,
	HIREDATE,
	SAL,
	COMM,
	DEPTNO
)
SELECT * 
FROM EMP WHERE EMPNO=@EMPNO;
END
GO

-- TRIGGER TO CALL EMP_LOG_SP FUNCTION ON UPDATE
CREATE TRIGGER LOG_EMP_BEFORE_UPDATE
ON EMP
INSTEAD OF UPDATE
AS
BEGIN
	DECLARE @EMPNO INTEGER;
	SET @EMPNO=(SELECT EMPNO FROM DELETED);
	EXEC aurionpro.empLogInfo @EMPNO;
	UPDATE EMP
	SET ENAME=I.ENAME,
		JOB=I.JOB,
		MGR=I.MGR,
		HIREDATE=I.HIREDATE,
		SAL=I.SAL,
		COMM=I.COMM,
		DEPTNO=I.DEPTNO
	FROM INSERTED I
	WHERE I.EMPNO=EMP.EMPNO;
END
GO

-- TESTING
BEGIN TRANSACTION
SELECT * FROM EMP WHERE EMPNO=7839;
UPDATE EMP SET
SAL=5000
WHERE EMPNO=7839;
SELECT * FROM EMP WHERE EMPNO=7839;
SELECT * FROM EMP_LOG;
ROLLBACK