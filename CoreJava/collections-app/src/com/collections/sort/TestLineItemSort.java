package com.collections.sort;

import java.util.ArrayList;
import java.util.Collections;

import com.techlabs.collections.LineItem;

public class TestLineItemSort {
	public static void main(String args[]) {
		ArrayList<LineItem> cart = new ArrayList<LineItem>();
		cart.add(new LineItem(2, "Bat", 10, 500.40));
		cart.add(new LineItem(5, "Stump", 6, 100.5));
		cart.add(new LineItem(3, "Ball", 30, 50.60));
		// cart.add("Hello");

		System.out.println("Print Details: ");
		Collections.sort(cart, new SortByNameComparator());
		displayDetails(cart);
	}
	
	private static void displayDetails(Iterable<LineItem> items) {
		for (LineItem product : items) {
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Total Cost: " + product.calculateTotalCost());
			System.out.println("");
		}
	}
}
