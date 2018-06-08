package com.techlabs.college.person.student;

import com.techlabs.college.person.Person;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Student extends Person implements Serializable {
	private Branch branch;
	private static final int AGE_LIMIT = 15;

	public Student(String name, String address, Date dob, Branch branch) {
		super(name, address, dob, AGE_LIMIT);
		setBranch(branch);
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
}
