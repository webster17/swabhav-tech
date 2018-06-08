package com.techlabs.array;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigInteger;
import java.text.ParseException;

class Student {
	String name, address, emailId, gender;
	Date dob;
	BigInteger contactNo;

	public void getData(String name, String address, Date dob, String emailId,
			BigInteger contactNo, String gender) {
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.gender = gender;
	}

	public String buildResume() {
		String resume = "Name of the student is : " + name + "\nAddress: "
				+ address + "\nGender: " + gender + " \nDate of Birth: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(dob)
				+ " \nEmail ID: " + emailId + " \nContact No: " + contactNo;
		return resume;
	}
}

public class TestStudent {
	public static void main(String args[]) throws ParseException {
		Student stud = new Student();
		stud.getData("Santosh", "Dahisar (E)", new SimpleDateFormat(
				"dd/MM/yyyy").parse("30/11/1995"), "santoshdangodra@gmail.com",
				new BigInteger("7666605343"), "Male");
		System.out.println(stud.buildResume());
	}
}