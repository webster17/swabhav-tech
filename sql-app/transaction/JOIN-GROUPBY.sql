USE aurionpro;
-- Departmentwise number of emploee 
SELECT DEPTNO,COUNT(*)
FROM EMP 
GROUP BY DEPTNO;

-- Jobwise number of employee
SELECT JOB, COUNT(*)
FROM EMP
GROUP BY JOB;

-- COUNT DEPT
SELECT COUNT(*) FROM DEPT;

-- Departmentwise, Jobwise wise number of employee
SELECT DEPTNO, JOB, COUNT(*)
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO ASC;

-- Display eployee with their dept name
SELECT EMPNO, ENAME, DNAME
FROM EMP E,DEPT D
WHERE E.DEPTNO=D.DEPTNO;

-- Display employee with their dept name using join
SELECT EMPNO, ENAME, DNAME
FROM EMP E
JOIN DEPT D
ON E.DEPTNO=D.DEPTNO;

-- Display depts with employee if any
SELECT EMPNO, ENAME, DNAME
FROM DEPT D
LEFT JOIN EMP E
ON D.DEPTNO=E.DEPTNO;

-- All depts which does not have any employee
SELECT D.DEPTNO, DNAME
FROM DEPT D
LEFT JOIN EMP E
ON D.DEPTNO=E.DEPTNO
WHERE EMPNO IS NULL;
--OR
SELECT DEPTNO, DNAME
FROM DEPT
WHERE DEPTNO NOT IN(SELECT D.DEPTNO
                    FROM EMP E
                    JOIN DEPT D
                    ON E.DEPTNO=D.DEPTNO
                    GROUP BY D.DEPTNO);

-- All employee name and their BOSS NAME
SELECT E.ENAME AS ENAME, ISNULL(M.ENAME, 'BOSS') AS BOSS
FROM EMP E
LEFT JOIN EMP M
ON M.EMPNO=E.MGR;

-- All employee name,dept name and his manager name
SELECT E.ENAME AS ENAME,D.DNAME AS DNAME, ISNULL(M.ENAME, 'BOSS') AS BOSS
FROM EMP E
JOIN DEPT D
ON E.DEPTNO=D.DEPTNO
LEFT JOIN EMP M
ON E.MGR=M.EMPNO;