package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class RectangleTest {
	public static void main(String args[]) {
		System.out.println("1st Object:");
		Rectangle rectangle1 = new Rectangle();
		rectangle1.setHeight(95);
		rectangle1.setWidth(10);
		rectangle1.setBorderColour("green");
		printDetails(rectangle1);

		System.out.println("2nd Object:");
		Rectangle rectangle2 = new Rectangle();
		rectangle2.setHeight(20);
		rectangle2.setWidth(150);
		rectangle2.setBorderColour("white");
		printDetails(rectangle2);

		Rectangle rectangle3 = rectangle1;
		rectangle3.setHeight(10);
		rectangle3.setWidth(10);
		rectangle3.setBorderColour("blue");
		System.out.println("3rd Object:");
		printDetails(rectangle3);

		System.out.println("1st Object after changing value by 3rd object:");
		printDetails(rectangle1);

		//rectangle3 = null;
		System.out.println("After doing 3rd object to null:");
		printDetails(rectangle3);
		
		System.out.println("Passing anonymous object to printDetails()");
		printDetails(new Rectangle());
	}

	public static void printDetails(Rectangle rectangle) {
		System.out.println("Hash code is: " + rectangle.hashCode());
		System.out.println("Height: " + rectangle.getHeight());
		System.out.println("Width: " + rectangle.getWidth());
		System.out.println("Border Colour: " + rectangle.getBorderColour());
		System.out.println("Area: " + rectangle.calculateArea() + "\n");
	}
}
