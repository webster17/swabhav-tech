SELECT 'SENIORITY' = x.sname + ' is more senior than ' + y.sname
FROM Student AS x INNER JOIN Student AS y
ON x.class > y.class
WHERE y.class = 3

