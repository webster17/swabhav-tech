package com.techlabs.collections.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.techlabs.collections.LineItem;

public class TestListItemCollection {
	public static void main(String args[]) {
		ArrayList cart = new ArrayList();
		cart.add(new LineItem(2, "Bat", 10, 500.40));
		cart.add(new LineItem(5, "Stump", 6, 100.5));
		cart.add(new LineItem(3, "Ball", 30, 50.60));
		// cart.add("Hello");

		System.out.println("Print Details: ");
		displayDetails(cart);

		System.out.println("Print Details using Iterator:");
		displayDetailsUsingIterator(cart);
	}

	private static void displayDetails(Iterable<LineItem> items) {
		for (LineItem product : items) {
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Total Cost: " + product.calculateTotalCost());
			System.out.println("");
		}
	}

	private static void displayDetailsUsingIterator(Iterable<LineItem> items) {
		Iterator<LineItem> iterator = items.iterator();

		while (iterator.hasNext()) {
			LineItem product = iterator.next();
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Total Cost: " + product.calculateTotalCost());
			System.out.println("");
		}
	}
}
