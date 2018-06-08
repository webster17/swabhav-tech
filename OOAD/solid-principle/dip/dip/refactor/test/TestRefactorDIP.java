package dip.refactor.test;

import dip.refactor.XMLLogger;
import dip.refactor.TaxCalculator;

public class TestRefactorDIP {

	public static void main(String args[]) {
		TaxCalculator taxCalculator = new TaxCalculator(new XMLLogger());
		taxCalculator.calculate(10000, 0);
	}
}
