package com.techlabs.collections;

public class LineItem implements Comparable<LineItem>{
	private int id;
	private String name;
	private int quantity;
	private double unitPrice;

	public LineItem(int id, String name, int quantity, double unitPrice) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	@Override
	public int compareTo(LineItem product) {
		return new Integer(id).compareTo(product.id);
	}

	public double calculateTotalCost() {
		return quantity * unitPrice;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
}
