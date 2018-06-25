SELECT c.course_name, c.course_number, d.dname
FROM (course c JOIN department_to_major d
ON c.offering_dept = d.dcode)
JOIN prereq p
ON p.course_number = c.course_number

