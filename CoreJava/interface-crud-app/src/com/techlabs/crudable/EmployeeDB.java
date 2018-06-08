package com.techlabs.crudable;

public class EmployeeDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Employee DB create.");
	}

	@Override
	public void read() {
		System.out.println("Employee DB read.");
	}

	@Override
	public void update() {
		System.out.println("Employee DB update.");
	}

	@Override
	public void delete() {
		System.out.println("Employee DB delete.");
	}

}
