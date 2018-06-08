package com.techlabs.college;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.techlabs.college.person.Person;
import com.techlabs.college.person.professor.Professor;
import com.techlabs.college.person.student.Branch;
import com.techlabs.college.person.student.Student;

public class CollegeAppConsole {

	private static final int ADD_STUDENT = 1;
	private static final int ADD_PROFESSOR = 2;
	private static final int DISPLAY = 3;
	private static final int COUNT = 4;
	private static final int DELETE_STUDENT = 5;
	private static final int DELETE_PROFESSOR = 6;
	private static final int EXIT = 7;
	private String name, address;
	private String branch;
	private Date dob;
	private double basicSalary;

	CollegeDataStore collegeDataStore = new CollegeDataStore();
	Student student;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
			System.in));

	public void start() throws FileNotFoundException, IOException,
			ClassNotFoundException, ParseException {
		collegeDataStore.DataImporter();
		System.out.println("Successfully Data Imported into College App.");

		int choice;
		do {
			System.out.println("***************************************");
			System.out
					.println("1. Add Student\n2. Add Professor\n3. Display\n4. Count\n5. Delete Student\n6. Delete Professor\n7. Exit");
			System.out.println("***************************************");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(bufferedReader.readLine());
			if (choice == ADD_STUDENT)
				addStudent();
			else if (choice == ADD_PROFESSOR)
				addProfessor();
			else if (choice == DISPLAY)
				display();
			else if (choice == COUNT)
				count();
			else if (choice == DELETE_STUDENT)
				deleteStudent();
			else if (choice == DELETE_PROFESSOR)
				deleteProfessor();
			else if (choice == EXIT)
				break;
			else
				System.out.println("Enter correct choice...");
		} while (true);

		collegeDataStore.DataExporter();
		System.out.println("Successfully Data Exported into file.");
	}

	private void generalDetailAdder() throws IOException, ParseException {
		System.out.println("Name: ");
		name = bufferedReader.readLine();

		System.out.println("Email: ");
		address = (bufferedReader.readLine());

		System.out.println("DOB: ");
		dob = new SimpleDateFormat("dd/MM/yyyy").parse(bufferedReader
				.readLine());
	}

	private void addStudent() throws IOException, ParseException {
		System.out.println("Enter Data to add new Student:");

		generalDetailAdder();

		System.out.println("Branch: ");
		branch = (bufferedReader.readLine());

		collegeDataStore.addStudent(new Student(name, address, dob, Branch
				.valueOf(branch)));
		System.out.println("Successfull added new student.");
	}

	private void addProfessor() throws IOException, ParseException {
		System.out.println("Enter Data to add new Professor:");

		generalDetailAdder();

		System.out.println("Basic Salary: ");
		basicSalary = Double.parseDouble(bufferedReader.readLine());

		collegeDataStore.addProfessor(new Professor(name, address, dob,
				basicSalary));
		System.out.println("Successfully added professor.");
	}

	private String commonDisplay(Person person) {
		return person.getId() + "\t" + person.getName() + "\t"
				+ person.getAddress() + "\t" + person.getDOB() + "\t"
				+ person.getAge();
	}

	private void display() {
		System.out.println("Students List:-");
		System.out.println("ID\t\t\t\t\tName\tEmail\t\t\tDOB\t\tAge\tBranch");
		for (Student student : collegeDataStore.getStudents()) {
			System.out.println(commonDisplay(student) + "\t"
					+ student.getBranch());
		}

		System.out.println("Professors List:-");
		System.out.println("ID\t\t\t\t\tName\tEmail\t\tDOB\t\tAge\tSalary");
		for (Professor professor : collegeDataStore.getProfessors()) {
			System.out.println(commonDisplay(professor) + "\t"
					+ professor.calculateSalary());
		}
	}

	private void count() {
		System.out.println("College Data Store Count:");
		System.out.println("No. of student is: "
				+ collegeDataStore.getStudentCount());
		System.out.println("No. of Professor is: "
				+ collegeDataStore.getProfessorCount());
	}

	// public void generalDelete() throws IOException{
	// System.out.println("Enter ID to delete record: ");
	// if (collegeDataStore.removeStudent(bufferedReader.readLine())) {
	// System.out.println("Successfully record deleted.");
	// }
	// System.out.println("Record does not exist with particular ID!");
	// }
	
	private void deleteStudent() throws IOException {
		System.out.println("Enter ID to delete record: ");
		if (collegeDataStore.removeStudent(bufferedReader.readLine())) {
			System.out.println("Successfully record deleted.");
		}
		System.out.println("Record does not exist with particular ID!");
	}

	private void deleteProfessor() throws IOException {
		System.out.println("Enter ID to delete record: ");
		if (collegeDataStore.removeStudent(bufferedReader.readLine())) {
			System.out.println("Successfully record deleted.");
		}
		System.out.println("Record does not exist with particular ID!");
	}
}