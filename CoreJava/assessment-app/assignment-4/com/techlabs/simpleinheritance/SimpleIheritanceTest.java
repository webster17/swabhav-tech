package com.techlabs.simpleinheritance;

import com.techlabs.simpleinheritance.BlackBoard;


public class SimpleIheritanceTest {
	public static void main(String args[]) {
		BlackBoard blackboard = new BlackBoard();

		blackboard.setLength(10);
		blackboard.setWidth(20);
		blackboard.setHeight(30);
		blackboard.setColour("Green");

		display(blackboard);
	}

	private static void display(BlackBoard blackboard) {
		System.out.println("Black Board: \nLength: " + blackboard.getLength());
		System.out.println("Width: " + blackboard.getWidth());
		System.out.println("Height: " + blackboard.getHeight());
		System.out.println("Colour: " + blackboard.getColour());
		System.out.println("Area is: " + blackboard.calculateArea());
		System.out.println("Volume is: " + blackboard.calculateVolume());
	}
}
