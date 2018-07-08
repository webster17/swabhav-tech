-- Display all employees in asscending order by name
SELECT * 
FROM EMP 
ORDER BY ENAME ASC;

-- Disaplay employees starting who's name with s
SELECT * 
FROM EMP 
WHERE ENAME LIKE 's%';


-- Display employees who's commision is null
SELECT *
FROM EMP
WHERE COMM IS NULL;

-- Display all employees in dept 10
SELECT *
FROM EMP
WHERE DEPTNO=10;

-- Display employee name in small case
SELECT LOWER(ENAME) AS ENAME
FROM EMP;

-- Display top 2 salary examing employee
SELECT TOP 2 *
FROM EMP 
ORDER BY SAL desc;

-- Display employee who are managers
SELECT *
FROM EMP
WHERE JOB='MANAGER';

-- Display employee details with ctc column
SELECT ENAME, SAL, COMM,
	SAL+ISNULL(COMM,0) AS TTLSAL,
	(SAL+ISNULL(COMM,0))*12 AS CTC
FROM EMP;


-- Display all employees in dept 10 and 20
SELECT *
FROM EMP
WHERE DEPTNO=10 OR DEPTNO=20;

-- All employee in same dept of 'smith'
SELECT *
FROM EMP
WHERE DEPTNO=(SELECT DEPTNO 
				FROM EMP
				WHERE ENAME='SMITH');

-- Employee have same salaray of blake
SELECT *
FROM EMP
WHERE SAL=(SELECT SAL 
			FROM EMP 
			WHERE ENAME='BLAKE');

-- Sum of salary of all employee
SELECT SUM(SAL)
FROM EMP;

-- Average salary of all employee
SELECT AVG(SAL)
FROM EMP;