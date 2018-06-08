package com.techlabs.employee;

import java.util.Date;

public class Employee{
	private int id, managerId, departmentNo;
	private String name, role;
	private Date doj;
	private Double salary,commission;
	
	public Employee(int id, int managerId, int departmentNo, String name,
			String role, Date doj, Double salary, Double commission) {
		super();
		this.id = id;
		this.managerId = managerId;
		this.departmentNo = departmentNo;
		this.name = name;
		this.role = role;
		this.doj = doj;
		this.salary = salary;
		this.commission = commission;
	}
	
	public double getAnnualSalary(){
		return (salary+commission)*12;
	}
	
	public int getId() {
		return id;
	}

	public int getManagerId() {
		return managerId;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public Date getDoj() {
		return doj;
	}

	public Double getSalary() {
		return salary;
	}

	public Double getCommission() {
		return commission;
	}	
}