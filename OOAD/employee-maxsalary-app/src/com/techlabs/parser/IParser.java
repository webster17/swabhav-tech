package com.techlabs.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.techlabs.employee.Employee;

public interface IParser {
	public void parseFile() throws FileNotFoundException, IOException, ParseException;
	public Iterable<Employee> getEmployeeList();
}