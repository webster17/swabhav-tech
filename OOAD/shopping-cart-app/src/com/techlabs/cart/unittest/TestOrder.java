package com.techlabs.cart.unittest;

import java.util.Date;

import com.techlabs.cart.LineItem;
import com.techlabs.cart.Order;
import com.techlabs.cart.Product;

public class TestOrder {
	public static void main(String args[]) {
		Product product1 = new Product("Bat", 100, 5);
		LineItem lineItem1 = new LineItem(product1, 4);
		Product product2 = new Product("Ball", 200, 10);
		LineItem lineItem2 = new LineItem(product2, 2);

		Order order1 = new Order(new Date(System.currentTimeMillis()));
		order1.addLineItem(lineItem1);
		order1.addLineItem(lineItem2);
		printDetails(order1);

		Product product3 = new Product("Mobile", 1000, 5);
		LineItem lineItem3 = new LineItem(product3, 5);
		Product product4 = new Product("Laptop", 10000, 10);
		LineItem lineItem4 = new LineItem(product4, 10);

		Order order2 = new Order(new Date(System.currentTimeMillis()));
		order2.addLineItem(lineItem3);
		order2.addLineItem(lineItem4);
		printDetails(order2);

	}

	private static void printDetails(Order order) {
		System.out.println("***** Order ****");
		System.out.println("ID: " + order.getId());
		System.out.println("Date: " + order.getDate());
		System.out
				.println("---------------------------------------------------------------------------");
		System.out
				.println("LID \tPID \tPName \tPrice \tDisc \tQty \tDiscPrice ");
		System.out
				.println("---------------------------------------------------------------------------");
		for (LineItem lineItem : order.getLineItems()) {
			System.out.println(lineItem.getId() + "\t"
					+ lineItem.getProduct().getId() + "\t"
					+ lineItem.getProduct().getName() + "\t"
					+ lineItem.getProduct().getPrice() + "\t"
					+ lineItem.getQuantity() + "\t"
					+ lineItem.getProduct().getDiscount() + "\t"
					+ lineItem.calculateItemCost());
		}
		System.out
				.println("---------------------------------------------------------------------------");
		System.out.println("Total Cost: \t\t\t\t\t" + order.checkoutPrice());
		System.out
				.println("---------------------------------------------------------------------------\n");
	}
}
