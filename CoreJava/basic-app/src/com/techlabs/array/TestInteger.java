package com.techlabs.array;

public class TestInteger {

	public static void main(String args[]) {
		int mark = 100;
		changeMark(mark);
		System.out.println(mark);

		int[] marks = { 10, 20, 30, 40 };
		changeMarks(marks);
		for (int m : marks)
			System.out.println(m);
	}

	static void changeMark(int mark) {
		mark = 0;
	}

	static void changeMarks(int[] marks) {
		for (int i = 0; i < marks.length; i++)
			marks[i] = 0;
	}
}
