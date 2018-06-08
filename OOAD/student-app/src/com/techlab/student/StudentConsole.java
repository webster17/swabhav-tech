package com.techlab.student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentConsole {

	private static final int ADD = 1;
	private static final int DISPLAY = 2;
	private static final int COUNT = 3;
	private static final int BUILDRESUME = 4;
	private static final int SEARCH = 5;
	private static final int DELETE = 6;
	private static final int EXIT = 7;

	StudentDataStore studentDataStore = new StudentDataStore();
	Student student;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
			System.in));
	private String name, email, about, designation, universityName,
			qualification, address;
	private float cgpa;
	private String[] skills = { "Web Design", "Interface Design",
			"Project Direction" };
	private String[] talents = { "HTML5", "CSS3", "javaScript", "jQuery",
			"JAVA", "PHP" };
	private long contactNo;

	public void add() throws IOException {
		System.out.println("Enter Data to add new Student:");

		System.out.println("Name: ");
		name = bufferedReader.readLine();

		System.out.println("Email: ");
		email = (bufferedReader.readLine());

		System.out.println("About: ");
		about = (bufferedReader.readLine());

		System.out.println("Designation: ");
		designation = (bufferedReader.readLine());

		System.out.println("University Name: ");
		universityName = (bufferedReader.readLine());

		System.out.println("Qualification: ");
		qualification = (bufferedReader.readLine());

		System.out.println("Contact No: ");
		contactNo = Long.parseLong((bufferedReader.readLine()));

		System.out.println("CGPA: ");
		cgpa = Float.parseFloat((bufferedReader.readLine()));

		System.out.println("Address: ");
		address = (bufferedReader.readLine());

		student = new Student(name, email, about, designation, universityName,
				qualification, contactNo, cgpa, skills, talents, address);
		studentDataStore.addStudent(student);
	}

	public void buildResume() throws IOException {
		BuildResume buildresume = new BuildResume();
		buildresume.autoResumeBuilder(studentDataStore.retrieve());
		System.out.println("Resume Building completed.");
	}

	public void display() {
		System.out.println("ID\tName\t\tAddress");
		for (Student student : studentDataStore.retrieve()) {
			System.out.println(student.getRollNo() + "\t" + student.getName()
					+ "\t" + student.getAddress());
		}
	}

	public void search() throws IOException {
		System.out.println("Enter keyword to search record: ");
		for (Student student : studentDataStore.search(bufferedReader
				.readLine())) {
			System.out.println(student.getRollNo() + "\t" + student.getName()
					+ "\t" + student.getAddress());
		}
	}

	public void delete() throws IOException {
		System.out.println("Enter ID to delete record: ");
		if (studentDataStore.removeStudent(bufferedReader.readLine())) {
			System.out.println("Successfully record deleted.");
		}
		System.out.println("Record does not exist!");
	}

	public void count() {
		System.out.println("Total No of student is: "
				+ studentDataStore.countRecords());
	}

	public void startApp() throws FileNotFoundException,
			ClassNotFoundException, IOException {
		studentDataStore.load();
		System.out.println("Loading Completed.");

		int choice;
		do {
			System.out.println("***************************************");
			System.out
					.println("1. Add \n2. Display \n3. Count\n4. Build Resume\n5. Search\n6. Delete\n7. Exit");
			System.out.println("***************************************");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(bufferedReader.readLine());
			if (choice == ADD)
				add();
			else if (choice == DISPLAY)
				display();
			else if (choice == COUNT)
				count();
			else if (choice == BUILDRESUME)
				buildResume();
			else if (choice == SEARCH)
				search();
			else if (choice == DELETE)
				delete();
			else if (choice == EXIT)
				break;
			else
				System.out.println("Enter correct choice...");
		} while (true);

		studentDataStore.store();
		System.out.println("Saving Completed.");
	}
}