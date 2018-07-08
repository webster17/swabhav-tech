USE aurionpro;
GO

-- MAKE TRIGGER TO MAKE INSERTED OR UPDATED NAME TO UPPER CASE
CREATE TRIGGER MAKE_NAME_TO_UPPER
ON EMP
after INSERT, UPDATE
AS
BEGIN
	UPDATE EMP
	SET ENAME= UPPER(I.ENAME)
	FROM INSERTED I;
END;
GO

-- TESTING
BEGIN TRANSACTION
UPDATE EMP
SET ENAME = 'kingaskj'
WHERE EMPNO=7839;
SELECT * FROM EMP WHERE EMPNO=7839;
ROLLBACK