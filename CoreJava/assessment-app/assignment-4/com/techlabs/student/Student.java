package com.techlabs.student;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = -7487361173899863788L;
	private String firstName;
	private String lastName;
	private String address;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
