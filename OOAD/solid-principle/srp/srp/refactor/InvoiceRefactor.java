package srp.refactor;

public class InvoiceRefactor {
	private int no;
	private String name;
	private double cost;
	private float discountPercentage;
	private final float GST = 0.05f;

	public InvoiceRefactor(int no, String name, double cost,
			float discountPercentage) {
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

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}
}