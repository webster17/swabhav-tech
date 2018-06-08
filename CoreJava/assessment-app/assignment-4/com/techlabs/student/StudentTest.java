package com.techlabs.student;

import java.io.*;
import java.util.ArrayList;
import com.techlabs.student.Student;

public class StudentTest {

	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	private static String defaultPath = "assignment-4//com//techlabs//student//resource//";
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException, ClassNotFoundException, FileNotFoundException {
		
		//To restore previous object state from file
		System.out.println("Reading Object State from File...");
		objectDeserialization();
		System.out.println("Successfull Object State loaded into arraylist.");

		int choice;
		do {
			System.out.println("***************************************");
			System.out.println("1. Add \n2. Display \n3. Count\n4. Exit");
			System.out.println("***************************************");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(bufferedReader.readLine());
			if (choice == 1)
				addStudentRecord();
			else if (choice == 2)
				displayStudentRecords();
			else if (choice == 3)
				countStudentRecords();
			else if(choice == 4)
				break;
			else
				System.out.println("Enter correct choice...");
		} while(true);

		//To save object state into file
		System.out.println("Object state saving from arraylist...");
		objectSerialization();
		System.out.println("Succesfully Object state saved into File!");
	}

	//To store object state into file
	private static void objectSerialization() throws FileNotFoundException, IOException {
		objectOutputStream = new ObjectOutputStream(new FileOutputStream(defaultPath + "student_data.ser"));
		objectOutputStream.writeObject(studentList);
		objectOutputStream.close();
	}
	
	//To add student record in ArrayList
	private static void addStudentRecord() throws IOException {
		Student student = new Student();
		System.out.println("Enter Data to add new Student:");
		System.out.println("First Name: ");
		student.setFirstName(bufferedReader.readLine());
		System.out.println("Last Name: ");
		student.setLastName(bufferedReader.readLine());
		System.out.println("Address: ");
		student.setAddress(bufferedReader.readLine());
		studentList.add(student);
	}
	
	//To Display all student records
	private static void displayStudentRecords() {
		int count = 0;
		for (Student student : studentList) {
			System.out.println("\nStudent " + (++count) + ": ");
			displayStudentDetails(student);
		}
	}

	//To display particular student record
	private static void displayStudentDetails(Student student) {
		System.out.println("Name: " + student.getFirstName() + " "
				+ student.getLastName());
		System.out.println("Address: " + student.getAddress());
	}

	//To count student record in the list
	private static void countStudentRecords() {
		System.out.println(studentList.size());
	}

	//To retrive object state from file
	@SuppressWarnings("unchecked")
	private static void objectDeserialization() throws FileNotFoundException,IOException, ClassNotFoundException {
		objectInputStream = new ObjectInputStream(new FileInputStream(defaultPath + "student_data.ser"));
		studentList = (ArrayList<Student>) objectInputStream.readObject();
	}
}
