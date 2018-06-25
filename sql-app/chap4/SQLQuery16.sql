SELECT c.course_name, c.course_number, c.credit_hours, c.offering_dept, p.prereq
FROM Course c JOIN Prereq p
ON c.course_number=p.course_number
ORDER BY c.course_number

