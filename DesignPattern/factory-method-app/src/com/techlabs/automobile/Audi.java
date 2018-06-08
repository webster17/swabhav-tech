package com.techlabs.automobile;

public class Audi implements IAutomibile{

	@Override
	public void start() {
		System.out.println("Audi start!");
	}

	@Override
	public void stop() {
		System.out.println("Audi stop!");
	}	
}