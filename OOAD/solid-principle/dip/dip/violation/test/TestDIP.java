package dip.violation.test;

import dip.violation.LogType;
import dip.violation.TaxCalculator;

public class TestDIP {

	public static void main(String args[]) {
		TaxCalculator taxCalculator = new TaxCalculator(LogType.XML);
		taxCalculator.calculate(10000, 0);
	}
}