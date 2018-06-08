package com.techlabs.cart.unittest;

import com.techlabs.cart.LineItem;
import com.techlabs.cart.Product;

public class TestLineItem {
	public static void main(String args[]) {
		Product product1 = new Product("Bat", 100, 5);
		LineItem lineItem1 = new LineItem(product1,4);
		printDetails(lineItem1);
		
		Product product2 = new Product("Ball", 200,10);
		LineItem lineItem2 = new LineItem(product2, 2);
		printDetails(lineItem2);
	}

	private static void printDetails(LineItem lineItem) {
		System.out.println("***** LineItem ****");
		System.out.println("ID: " + lineItem.getId());
		System.out.println("Product ID: " +lineItem.getProduct().getId());
		System.out.println("Name: " + lineItem.getProduct().getName());
		System.out.println("Price: " + lineItem.getProduct().getPrice());
		System.out.println("Discount: " + lineItem.getProduct().getDiscount());
		System.out.println("DiscountPrice: " + lineItem.getProduct().calculateDiscountCost());
		System.out.println("Quantity: " + lineItem.getQuantity());
		System.out.println("TotalCost: " + lineItem.calculateItemCost()+"\n");
	}
}
