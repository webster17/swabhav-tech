package com.techlabs.employee.test;

import com.techlabs.employee.Developer;
import com.techlabs.employee.Employee;
import com.techlabs.employee.Manager;

public class TestEmployee {
	public static void main(String args[]) {
		Manager manager = new Manager("Santosh Dangodra", 5000);
		printDetails(manager);
		
		Developer developer = new Developer("Darshan Joshi", 8000);
		printDetails(developer);
	}

	public static void printDetails(Employee employee) {
		System.out.println("** Employee Details **");
		System.out.println("Emp ID: " + employee.getEmpno());
		System.out.println("Name: " + employee.getName());
		System.out.println("Salary: " + employee.getSalary()+"\n");
	}
}
