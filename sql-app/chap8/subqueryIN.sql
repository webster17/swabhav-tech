SELECT Student.sname, Student.stno
    FROM   Student
    WHERE  Student.stno
      IN (SELECT   gr.student_number
          FROM     Grade_report gr
          WHERE    gr.grade = 'B' OR  gr.grade = 'A')
    ORDER BY Student.stno
