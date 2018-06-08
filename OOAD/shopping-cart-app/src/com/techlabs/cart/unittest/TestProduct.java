package com.techlabs.cart.unittest;

import com.techlabs.cart.Product;

public class TestProduct {
	public static void main(String args[]) {
		Product product1 = new Product("Bat", 100, 5f);
		printDetails(product1);
		Product product2 = new Product("Ball", 200);
		printDetails(product2);
	}

	private static void printDetails(Product product) {
		System.out.println("***** Product ****");
		System.out.println("ID: " + product.getId());
		System.out.println("Name: " + product.getName());
		System.out.println("Price: " + product.getPrice());
		System.out.println("Discount: " + product.getDiscount());
		System.out.println("DiscountPrice: " + product.calculateDiscountCost()+"\n");
	}
}
