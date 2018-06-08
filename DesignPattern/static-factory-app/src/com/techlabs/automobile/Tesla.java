package com.techlabs.automobile;

public class Tesla implements IAutomibile{

	@Override
	public void start() {
		System.out.println("Tesla start!");
	}

	@Override
	public void stop() {
		System.out.println("Tesla stop!");
	}	
}