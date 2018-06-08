package com.techlabs.crudable;

public class CustomerDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Cutomer DB create.");
	}

	@Override
	public void read() {
		System.out.println("Cutomer DB read.");
	}

	@Override
	public void update() {
		System.out.println("Cutomer DB update.");
	}

	@Override
	public void delete() {
		System.out.println("Cutomer DB delete.");
	}

}
