package com.techlabs.cart.test;

import java.util.Date;

import com.techlabs.cart.Customer;
import com.techlabs.cart.LineItem;
import com.techlabs.cart.Order;
import com.techlabs.cart.Product;

public class TestCart {
	public static void main(String args[]) {
		Product product1 = new Product("Bat", 100, 5);
		LineItem lineItem1 = new LineItem(product1, 4);
		Product product2 = new Product("Ball", 200, 10);
		LineItem lineItem2 = new LineItem(product2, 2);
		LineItem lineItem9 = new LineItem(product1,6);
		Order order1 = new Order(new Date(System.currentTimeMillis()));
		order1.addLineItem(lineItem1);
		order1.addLineItem(lineItem2);
		order1.addLineItem(lineItem9);
		

		Product product3 = new Product("Mobile", 1000, 5);
		LineItem lineItem3 = new LineItem(product3, 5);
		Product product4 = new Product("Laptop", 10000, 10);
		LineItem lineItem4 = new LineItem(product4, 10);
		Order order2 = new Order(new Date(System.currentTimeMillis()));
		order2.addLineItem(lineItem3);
		order2.addLineItem(lineItem4);

		Customer customer1 = new Customer("Santosh");
		customer1.addOrder(order1);
		customer1.addOrder(order2);
		printDetails(customer1);
		
		Product product5 = new Product("Wallet", 100, 2);
		LineItem lineItem5 = new LineItem(product5, 1);
		Product product6 = new Product("Shoes", 400, 10);
		LineItem lineItem6 = new LineItem(product6, 2);
		Order order3 = new Order(new Date(System.currentTimeMillis()));
		order3.addLineItem(lineItem5);
		order3.addLineItem(lineItem6);

		Product product7 = new Product("Jeans", 1000, 5);
		LineItem lineItem7 = new LineItem(product7, 4);
		Product product8 = new Product("Shirt", 500, 10);
		LineItem lineItem8 = new LineItem(product8, 4);
		Order order4 = new Order(new Date(System.currentTimeMillis()));
		order4.addLineItem(lineItem7);
		order4.addLineItem(lineItem8);
		
		Customer customer2 = new Customer("Sarvesh");
		customer2.addOrder(order3);
		customer2.addOrder(order4);
		printDetails(customer2);

	}

	private static void printDetails(Customer customer) {

		System.out.println("***** Customer ****");
		System.out.println("ID: " + customer.getId());
		System.out.println("Name: " + customer.getName() + "\n");

		for (Order order : customer.getOrders()) {
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
						+ lineItem.getProduct().getDiscount() + "\t"
						+ lineItem.getQuantity() + "\t"
						+ lineItem.calculateItemCost());
			}
			System.out
					.println("---------------------------------------------------------------------------");
			System.out
					.println("Total Cost: \t\t\t\t\t" + order.checkoutPrice());
			System.out
					.println("---------------------------------------------------------------------------\n");
		}
	}
}
