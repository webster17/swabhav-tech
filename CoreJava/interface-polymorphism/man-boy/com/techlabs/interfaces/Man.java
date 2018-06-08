package com.techlabs.interfaces;

public class Man implements IMannerable{

	@Override
	public void wish() {
		System.out.println("Good Day.");
	}

	@Override
	public void depart() {
		System.out.println("Good Bye.");
	}

}
