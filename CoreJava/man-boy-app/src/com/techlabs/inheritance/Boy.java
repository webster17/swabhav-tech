package com.techlabs.inheritance;

public class Boy extends Man {

	static {
		System.out.println("Boys static block.");
	}

	public Boy() {
		super();
		System.out.println("Boy is created...");
	}

	public void walk() {
		System.out.println("Boy is waking...");
	}

	@Override
	public void play() {
		System.out.println("Boy is playing...");
	}
}
