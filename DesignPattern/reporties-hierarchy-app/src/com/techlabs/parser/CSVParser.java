package com.techlabs.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.techlabs.employee.Employee;
import com.techlabs.loader.ILoadable;

public class CSVParser implements IParser{
	
	ILoadable iLoadable;
	String fileContent;
	Employee employee;
	private ArrayList<Employee> employeeRecords = new ArrayList<Employee>();
		

	public CSVParser(ILoadable iLoadable) {
		this.iLoadable=iLoadable;
	}
	
	@Override
	public void parseFile() throws FileNotFoundException, IOException, ParseException{
		fileContent = iLoadable.fileContentReader();
		String[] stringLines = fileContent.split("\n");
		for (String string : stringLines) {
			generateEmployeeDetails(string.replaceAll("\'", "").split(","));
		}
	}
	
	private void generateEmployeeDetails(String[] employeeDetails) throws ParseException{
		int id, managerId, departmentNo;
		String name, role;
		Date doj;
		Double salary,commission;
		
		id = Integer.parseInt(employeeDetails[0]);
		System.out.println(id);
		name = employeeDetails[1];
		role=employeeDetails[2];
		managerId = (employeeDetails[3].equalsIgnoreCase(null))?Integer.parseInt(employeeDetails[3]):0;
		doj = new SimpleDateFormat("dd-MMMM-yy").parse(employeeDetails[4]);
		salary = (employeeDetails[5].equalsIgnoreCase(null))?(Double.parseDouble(employeeDetails[5])):0;
		commission = (employeeDetails[6].equalsIgnoreCase(null))?(Double.parseDouble(employeeDetails[6])):0;
		departmentNo = Integer.parseInt(employeeDetails[7]);
		
		employee = new Employee(id, managerId, departmentNo, name, role, doj, salary, commission);
		employeeRecords.add(employee);
	}
	
	
	@Override
	public ArrayList<Employee> getEmployeeList(){
		return employeeRecords;
	}
}