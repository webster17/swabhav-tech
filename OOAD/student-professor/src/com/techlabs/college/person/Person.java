package com.techlabs.college.person;

import com.techlabs.college.exception.AgeLimitException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public abstract class Person {
	private final UUID id;
	private String name;
	private String address;
	private String pattern = "dd/MM/yyyy";
	private Date dob;
	private final int ageLimit;

	public Person(String name, String address, Date dob, int ageLimit) {
		id = UUID.randomUUID();
		this.name = name;
		this.address = address;
		this.ageLimit = ageLimit;
		setDOB(dob);
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDOB() {
		SimpleDateFormat formatedDate = new SimpleDateFormat(pattern);
		return formatedDate.format(this.dob);
	}

	public void setDOB(Date dob) {
		if (calculateAge(dob).getYears() < ageLimit)
			throw new AgeLimitException("Age must be greater than or equal to "
					+ ageLimit + " year.");
		else
			this.dob = dob;
	}
	
	private Period calculateAge(Date dob){
		return Period.between(dob.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate(), LocalDate.now());
	}
	
	public int getAge(){
		return calculateAge(this.dob).getYears();
	}
}
