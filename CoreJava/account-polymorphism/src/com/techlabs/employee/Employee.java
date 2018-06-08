package com.techlabs.employee;

public abstract class Employee {
	private final int empNo;
	private static int autoIncrement = 0;
	private final String name;
	private double basic;

	public Employee(String name, double basic) {
		this.empNo = autoIncrement + 1;
		this.name = name;
		this.basic = basic;
	}

	public double getBasic() {
		return basic;
	}

	public int getEmpno() {
		return empNo;
	}

	public String getName() {
		return name;
	}
	
	public abstract double getSalary();

}
