package com.techlabs.cart;

public class Product {
	private static int idCounter;
	private final int id;
	private String name;
	private double price;
	private float discount;

	static {
		idCounter = 100;
	}

	public Product(String name, double price) {
		this(name, price, 0);
	}

	public Product(String name, double price, float discount) {
		this.id = ++idCounter;
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public double calculateDiscountCost() {
		return price - price * (discount / 100);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
