package com.techlabs.multipleinheritance;

import com.techlabs.multipleinheritance.Circle;

public class CircleTest {
	public static void main(String args[]){
		Circle circle = new Circle();
		circle.setRadious(10);
		System.out.println("Circle Data:");
		System.out.println("Radious is: "+circle.getRadious());
		System.out.println("Area of circle is: "+circle.calculateArea());
		System.out.println("Perimeter of circle is: "+circle.calculatePerimeter());
	}
}
