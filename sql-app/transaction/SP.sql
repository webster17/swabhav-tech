USE aurionpro;
GO

CREATE PROCEDURE uspGetEmployee
AS
SELECT * FROM EMP;
GO

CREATE PROCEDURE uspGetEmployeesTest   
    @ENAME nvarchar(50),   
    @SAL nvarchar(50)
AS   
    SELECT EMPNO, ENAME, JOB
    FROM EMP  
    WHERE ENAME = @ENAME AND SAL = @SAL  
    AND COMM IS NULL;  
GO 

EXECUTE uspGetEmployeesTest N'SMITH', N'800';  
-- EXEC uspGetEmployeesTest @ENAME = N'SMITH', @SAL = N'800';
-- uspGetEmployeesTest @ENAME = N'SMITH', @SAL = N'800';  
GO

EXEC uspGetEmployee;
-- uspGetEmployee;
GO

DROP PROCEDURE uspGetEmployee;
DROP PROCEDURE uspGetEmployeesTest;