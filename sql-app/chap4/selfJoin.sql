SELECT 'SENIORITY' = x.sname + ' is in a higher class than ' + y.sname
FROM Student AS x, Student AS y
WHERE y.class = 3
AND x.class > y.class


