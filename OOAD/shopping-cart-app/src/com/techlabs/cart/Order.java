package com.techlabs.cart;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private static int idCounter;
	private final int id;
	private Date date;
	ArrayList<LineItem> lineItems = new ArrayList<LineItem>();

	static {
		idCounter = 1000;
	}

	public Order(Date date) {
		this.id = ++idCounter;
		this.date = date;
	}

	public void addLineItem(LineItem lineItem) {
		boolean flag = false;
		for (LineItem item : lineItems) {
			if (lineItem.getProduct().getId() == item.getProduct().getId()) {
				item.setQuantity(item.getQuantity()
						+ lineItem.getQuantity());
				flag = true;
			}
		}
		if (flag == false)
			lineItems.add(lineItem);
	}

	public double checkoutPrice() {
		double totalCost = 0;
		for (LineItem lineItem : lineItems) {
			totalCost += lineItem.calculateItemCost();
		}
		return totalCost;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
