SELECT stno, sname, relationship, age
FROM Student s JOIN Dependent d
ON s.stno=d.pno
