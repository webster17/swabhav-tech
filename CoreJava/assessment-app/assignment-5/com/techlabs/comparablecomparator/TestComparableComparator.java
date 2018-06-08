package com.techlabs.comparablecomparator;

import com.techlabs.comparablecomparator.Student;
import java.util.ArrayList;
import java.util.Collections;

public class TestComparableComparator {

	public static void main(String args[])
	{
		 ArrayList<Student> studentList=new ArrayList<Student>();
		 
		 Student stud1=new Student(2,"Santosh","Dangodra","Dahisar");
		 Student stud2=new Student(1,"Darsha","Joshi","Miraroad");
		 Student stud3=new Student(3,"Chirag","sardhara","Vasai");
		 
		 studentList.add(stud1);
		 studentList.add(stud2);
		 studentList.add(stud3);
		 
		 Collections.sort(studentList,Student.idComparator);
		 
		 System.out.println("After sorting student list is "+studentList);
		 
	}
}
