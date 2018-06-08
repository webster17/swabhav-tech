package com.techlabs.cart;

public class LineItem {
	private static int idCounter;
	private final int id;
	private Product product;
	private int quantity;

	static {
		idCounter = 500;
	}

	public LineItem(Product product, int qunatity) {
		this.id = ++idCounter;
		this.product = product;
		this.quantity = qunatity;
	}

	public double calculateItemCost() {
		return product.calculateDiscountCost() * quantity;
	}

	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
