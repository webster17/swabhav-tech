package com.techlabs.comparablecomparator;

import java.util.Comparator;

public class Student implements Comparable<Student> {

	private String firstName;
	private String lastName;
	private String address;
	private int id;

	@Override
	public int compareTo(Student student) {
		return (this.id - student.id);
	}

	@Override
	public String toString() {
		return "id is: "+id+" Name is: "+firstName+" "+lastName+" Address is: "+address;
	}

	public Student(int id, String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = id;
	}

	public static Comparator<Student> nameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	};
	
	public static Comparator<Student> addressComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getAddress().compareTo(s2.getAddress());
		}
	};
	
	public static Comparator<Student> idComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.id-s2.id;
		}
	};

	public void displayStudentDetails() {
		System.out.println("Id of student is: " + id);
		System.out.println("Name of student is " + firstName + " " + lastName);
		System.out.println("Address of student is " + address);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

