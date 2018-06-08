package com.techlabs.array;

public class TestOverload {
	private static void print() {
		System.out.println("------------------------------------");
	}

	private static void print(char c) {
		for (int i = 0; i < 50; i++)
			System.out.print(c);
		System.out.println();
	}

	private static void print(int no) {
		System.out.println("Integer No: " + no);
	}

	private static void print(float no) {
		System.out.println("Float no: " + no);
	}

	private static void print(double no) {
		System.out.println("Double No: " + no);
	}

	public static void main(String args[]) {
		print();
		print('=');
		print(10);
		print(100.5f);
		print(50.63247);
	}
}
