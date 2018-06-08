package srp.violation;

public class Invoice {
	private int no;
	private String name;
	private double cost;
	private float discountPercentage;
	private final float GST = 0.05f;

	public Invoice(int no, String name, double cost, float discountPercentage) {
		this.no = no;
		this.name = name;
		this.cost = cost;
		this.discountPercentage = discountPercentage;
	}

	private double calculatedDiscount() {
		return cost * (discountPercentage / 100);
	}

	private double calculatedTax() {
		return cost * (GST / 100);
	}

	public double totalCost() {
		return cost - calculatedDiscount() + calculatedTax();
	}

	public void printInvoice() {
		System.out.println("ID: " + no + "\nName: " + name + "\nTotalCost: "
				+ totalCost() + "\n");
	}
}