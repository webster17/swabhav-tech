SELECT *
FROM Prereq p FULL OUTER JOIN Course c
ON p.course_number = c.course_number