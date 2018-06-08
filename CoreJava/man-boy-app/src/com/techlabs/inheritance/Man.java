package com.techlabs.inheritance;

public class Man {
	
	static{
		System.out.println("Man static block.");
	}
	public Man(){
		System.out.println("Man is created...");
	}
	
	public void eat() {
		System.out.println("Man is eating...");
	}

	public void play() {
		System.out.println("Man is playing...");
	}

	public void read() {
		System.out.println("Man is reading...");
	}
}
