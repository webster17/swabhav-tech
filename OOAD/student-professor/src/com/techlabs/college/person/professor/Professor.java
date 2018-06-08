package com.techlabs.college.person.professor;

import com.techlabs.college.person.Person;
import com.techlabs.college.person.ISalariedEmployee;
import com.techlabs.college.exception.MinimumSalaryException;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Professor extends Person implements ISalariedEmployee,Serializable {
	private double basicSalary;
	private static final int AGE_LIMIT = 30;

	public Professor(String name, String address, Date dob, double basicSalary) {
		super(name, address, dob, AGE_LIMIT);
		setBasicSalary(basicSalary);
	}

	@Override
	public double calculateSalary() {
		double pfCost, hraCost, daCost, incomeTax, grossSalary, deduction;
		pfCost = basicSalary * pf / 100;
		hraCost = basicSalary * hra / 100;
		daCost = basicSalary * da / 100;
		incomeTax = basicSalary * 10 / 100;
		grossSalary = basicSalary + daCost + hraCost;
		deduction = pfCost + incomeTax;
		return (grossSalary - deduction);
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		if (basicSalary < 10000)
			throw new MinimumSalaryException(
					"Basic Salary must be greater than or equal to Rs. 10000/-");
		else
			this.basicSalary = basicSalary;
	}
}
