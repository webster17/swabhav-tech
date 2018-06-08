package com.techlabs.array;

public class SubStringOverload {
	public static void main(String str[]){
		String s = str[0];
		System.out.println("Domain name is: "+s.substring(s.indexOf('.')+1, s.lastIndexOf('.')));
		System.out.println("Argument name is: "+s.substring(s.indexOf('=')+1));
	}
}
