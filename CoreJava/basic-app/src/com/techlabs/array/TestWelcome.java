package com.techlabs.array;

public class TestWelcome {
	public static void main(String names[]) {
		System.out.println("Hello, World!!!");
		if(names.length == 0){
			System.out.println(names.length);
		}
		else{
			for(String n : names)
				System.out.println("Hello, "+n);
		}
	}
}