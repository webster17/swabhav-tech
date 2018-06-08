package com.techlabs.array;

public class SplitOverload {
	public static void main(String str[]) {
		String[] s = str[0].split("\\.", 3);
		System.out.println("Domain name is: " + s[1]);
		s = str[0].split("=");
		System.out.println("Argument name is: " + s[1]);
	}
}
