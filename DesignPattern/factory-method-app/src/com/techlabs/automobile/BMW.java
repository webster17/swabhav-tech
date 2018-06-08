package com.techlabs.automobile;

public class BMW implements IAutomibile{

	@Override
	public void start() {
		System.out.println("BMW start!");
	}

	@Override
	public void stop() {
		System.out.println("BMW stop!");
	}	
}