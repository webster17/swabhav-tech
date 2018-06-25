SELECT *
FROM Course c LEFT OUTER JOIN Prereq p
ON c.course_number = p.course_number