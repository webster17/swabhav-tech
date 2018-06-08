package com.techlabs.employee;

import java.util.ArrayList;

public class EmployeeDataAnalyser {

	private ArrayList<Employee> employeeRecord= new ArrayList<Employee>();

	public EmployeeDataAnalyser(Iterable<Employee> iterable){
		iterable.forEach(employeeRecord::add);
	}
	
	public Iterable<Employee> getEmployeeRecord() {
		return employeeRecord;
	}
	
	private double getMaximumSalary(){
		double salary=0;
		for (Employee employee : employeeRecord) {
			if(employee.getAnnualSalary() > salary)
				salary=employee.getAnnualSalary();
		}
		return salary;
	}
	
	public Iterable<Employee> highestPaidEmployee() {
		double maximumSalary = getMaximumSalary();
		ArrayList<Employee> searchRecord = new ArrayList<Employee>();
		for (Employee employee : employeeRecord) {
			if (employee.getAnnualSalary() == maximumSalary) {
				searchRecord.add(employee);
			}
		}		
		return searchRecord;
	}
}