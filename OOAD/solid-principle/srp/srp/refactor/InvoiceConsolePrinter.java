package srp.refactor;

public class InvoiceConsolePrinter {
	public void printInvoice(InvoiceRefactor invoice) {
		System.out.println("ID\t\t: " + invoice.getNo() + "\nName\t\t: "
				+ invoice.getName() + "\nTotal Cost\t: " + invoice.totalCost());
	}
}