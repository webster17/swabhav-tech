package com.techlab.student;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
public class Student implements Serializable {

	private final UUID rollNo;
	private String name, designation, email, about, universityName,
			qualification, address;
	private float cgpa;
	private String[] skills, talents;
	private long contactNo;

	public Student(String name, String email, String about, String designation,
			String universityName, String qualification, long contactNo,
			float cgpa, String[] skills, String[] talents, String address) {
		this.rollNo = UUID.randomUUID();
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.about = about;
		this.universityName = universityName;
		this.qualification = qualification;
		this.cgpa = cgpa;
		this.contactNo = contactNo;
		this.skills = skills;
		this.talents = talents;
		this.address = address;
	}

	public UUID getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String[] getTalents() {
		return talents;
	}

	public void setTalents(String[] talents) {
		this.talents = talents;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
}