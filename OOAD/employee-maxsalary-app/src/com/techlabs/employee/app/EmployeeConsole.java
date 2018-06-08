package com.techlabs.employee.app;

import com.techlabs.employee.Employee;
import com.techlabs.employee.EmployeeDataAnalyser;
import com.techlabs.loader.LocalFileLoader;
import com.techlabs.parser.CSVParser;
import com.techlabs.parser.IParser;

public class EmployeeConsole {

	IParser iParser;
	EmployeeDataAnalyser employeeDataAnalyser;
	int[][] counter;

	private void displayHighestPaidEmployee() {
		System.out.println("Highest Paid Employee List:");
		System.out.println("ID\t\tName\t\tAnnual Salary");
		for (Employee employee : employeeDataAnalyser.highestPaidEmployee()) {
			System.out.println(employee.getId() + "\t" + employee.getName()
					+ "\t" + employee.getAnnualSalary());
		}
	}

	private void displayDepartmentWiseEmployeeCounter() {
//		Map<Integer, Long> noOfEmployeesInDept = ((Object) employeeDataAnalyser)
//				.stream().collect(
//						Collectors.groupingBy(Employee::getDeptNo,
//								Collectors.counting()));
//		System.out.println("No's of employee in each department: "
//				+ noOfEmployeesInDept);
	}

	private void displayJobWiseEmployeeCounter() {
//		Map<String, Long> noOfEmployeesByDesignation = empList.stream()
//				.collect(Collectors.groupingBy(Employee::getRole,
//								Collectors.counting()));
	}

	public void startApp() {
		iParser = new CSVParser(new LocalFileLoader(
				"src//com//techlabs//resources//dataFile.txt"));
		
		employeeDataAnalyser = new EmployeeDataAnalyser(iParser.getEmployeeList());
		

		displayHighestPaidEmployee();
		displayJobWiseEmployeeCounter();
		displayDepartmentWiseEmployeeCounter();

		employeeDataAnalyser.highestPaidEmployee();
	}
}
