package srp.refactor.test;

import srp.refactor.InvoiceConsolePrinter;
import srp.refactor.InvoiceRefactor;

public class TestInvoiceRefactor {
	public static void main(String args[]) {
		new InvoiceConsolePrinter().printInvoice(new InvoiceRefactor(112,
				"Furniture", 25000, 5));
	}
}