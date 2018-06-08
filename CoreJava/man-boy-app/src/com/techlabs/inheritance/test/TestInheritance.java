package com.techlabs.inheritance.test;

import com.techlabs.inheritance.Boy;
import com.techlabs.inheritance.Infant;
import com.techlabs.inheritance.Kid;
import com.techlabs.inheritance.Man;

public class TestInheritance {
	public static void main(String args[]) {
		//case1();
		case2();
		//case3();
		//case4();
	}

	private static void case1() {
		System.out.println("\nCase1:");
		Man man;
		man = new Man();
		man.eat();
		man.play();
		man.read();
	}

	private static void case2() {
		System.out.println("\nCase2:");
		Boy boy;
		boy = new Boy();
		boy.eat();
		boy.read();
		boy.walk();
		boy.play();
	}

	private static void case3() {
		System.out.println("\nCase3:");
		Man man;
		man = new Boy();
		man.eat();
		man.play();
		man.read();
	}

	private static void case4() {
		System.out.println("\nCase4:");
		atThePark(new Man());
		atThePark(new Boy());
		atThePark(new Kid());
		atThePark(new Infant());
	}

	private static void atThePark(Man man) {
		System.out.println("\nAt the Park");
		man.play();
	}
}
