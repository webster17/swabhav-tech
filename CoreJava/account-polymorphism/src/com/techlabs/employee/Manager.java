package com.techlabs.employee;

public class Manager extends Employee {
	private double hra;
	private static final int HRAPERCENTAGE = 50;
	private double ta;
	private static final int TAPERCENTAGE = 40;

	public Manager(String name, double basic) {
		super(name, basic);
		hra = (basic * HRAPERCENTAGE) / 100;
		ta = (basic * TAPERCENTAGE) / 100;
	}

	public double getHra() {
		return hra;
	}

	public double getTa() {
		return ta;
	}

	@Override
	public double getSalary() {
		return getBasic() + hra + ta;
	}
}
