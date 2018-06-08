package com.techlabs.employee;

public class Developer extends Employee {
	private double perks;
	private static final int PERKSPERCENTAGE = 30;

	public Developer(String name, double basic) {
		super(name, basic);
		perks = (basic * PERKSPERCENTAGE) / 100;
	}

	public double getPerks() {
		return perks;
	}

	@Override
	public double getSalary() {
		return getBasic() + perks;
	}
}
