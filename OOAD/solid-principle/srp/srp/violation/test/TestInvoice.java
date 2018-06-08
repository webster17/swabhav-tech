package srp.violation.test;

import srp.violation.Invoice;

public class TestInvoice {
	public static void main(String args[]) {
		Invoice invoice = new Invoice(112, "Furniture", 25000, 5);
		invoice.printInvoice();
	}
}