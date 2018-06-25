SELECT  Student.sname, Student.stno
    FROM    Student, Grade_report gr
    WHERE   Student.stno = gr.student_number
    AND        (gr.grade = 'B' OR gr.grade = 'A')
