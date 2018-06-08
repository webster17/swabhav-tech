package com.techlabs.circle.test;

import com.techlabs.circle.Circle;
import com.techlabs.circle.BorderStyleOption.borderStyles;

public class CircleTest {
	public static void main(String args[]) {
		System.out.println("1st Object:");
		Circle circle1 = new Circle(2.5f);
		displayDetails(circle1);
		;

		System.out.println("2nd Object:");
		Circle circle2 = new Circle(3.5f, borderStyles.DOTTED);
		displayDetails(circle2);


		System.out.println("3nd Object:");
		Circle circle3 = new Circle (4.5f, borderStyles.DOUBLE);
		displayDetails(circle2);
		
		Circle[] circles = new Circle[3];
		circles[0] = circle1;
		circles[1] = circle2;
		circles[2] = circle3;
		
		for(Circle circle : circles){
			displayDetails(circle);
		}
	}

	public static void displayDetails(Circle circle) {
		System.out.println("Radious: " + circle.getRadius());
		System.out.println("Border Style: " + circle.getBorderStyle());
		System.out.println("Area: " + circle.calculateArea());
		System.out.println("Hash Code:" + circle.hashCode()+"\n");
	}

}
