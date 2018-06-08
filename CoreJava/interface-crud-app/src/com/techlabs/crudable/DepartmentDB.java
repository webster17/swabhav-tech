package com.techlabs.crudable;

public class DepartmentDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Department DB create.");
	}

	@Override
	public void read() {
		System.out.println("Department DB read.");
	}

	@Override
	public void update() {
		System.out.println("Department DB update.");
	}

	@Override
	public void delete() {
		System.out.println("Department DB delete.");
	}

}
