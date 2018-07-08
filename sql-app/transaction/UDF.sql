USE aurionpro;
go

CREATE FUNCTION getEmployeeHavingCTC(@salary MONEY)
RETURNS TABLE
RETURN
	select * FROM EMP where (SAL+COMM)*12>@salary;
GO

select * FROM getEmployeeHavingCTC(20000)



CREATE FUNCTION GetAllEmployee(@sal money)  
RETURNS TABLE  
AS  
RETURN  
    SELECT * FROM EMP WHERE SAL>=@sal;

SELECT * from GetAllEmployee(1500);
