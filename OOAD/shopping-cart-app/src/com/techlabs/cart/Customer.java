package com.techlabs.cart;

import java.util.ArrayList;

public class Customer {
	private static int idCounter;
	private final int id;
	private String name;
	ArrayList<Order> orders = new ArrayList<Order>();

	static {
		idCounter = 2000;
	}

	public Customer(String name) {
		this.id = ++idCounter;
		this.name = name;
	}

	public void addOrder(Order order) {
		orders.add(order);
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

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
