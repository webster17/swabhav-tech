package com.techlabs.objectcreationways;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.*;

public class TestObjectCreationWays {

	public static void main(String args[]) throws FileNotFoundException, ClassNotFoundException, IOException {

		objectCreation1();

		objectCreation2();

		objectCreation3();

		objectCreation4();
	}

	private static void objectCreation1() {
		Student student;
		try {
			student = (Student) Class.forName("com.techlabs.objectcreationways.Student").newInstance();

			student.setAddress("Dahisar");
			student.setFirstName("santosh");
			student.setLastName("Dangodra");
			student.displayStudentDetails();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void objectCreation2() {
		Student student = new Student();
		try {
			student.setAddress("Dahisar");
			student.setFirstName("santosh");
			student.setLastName("Dangodra");
			Student studentClone = (Student) student.clone();
			
			System.out.println(student.hashCode());
			System.out.println(studentClone.hashCode());
			
			studentClone.displayStudentDetails();
		} catch (CloneNotSupportedException e) {}
	}

	private static void objectCreation3() {
		try {
			Constructor<Student> constructor = Student.class.getDeclaredConstructor();
			
			Student student=constructor.newInstance();
			student.setAddress("Dahisar");
			student.setFirstName("santosh");
			student.setLastName("Dangodra");
			student.displayStudentDetails();
		} catch (Exception e) {}
	}

	private static void objectCreation4() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream;
		String defaultPath = "assignment-5//com//techlabs//objectcreationways//";
		objectInputStream = new ObjectInputStream(new FileInputStream(defaultPath+"student-serialize.ser"));
		Student student = (Student) objectInputStream.readObject();
		student.displayStudentDetails();
		objectInputStream.close();
	}

}

