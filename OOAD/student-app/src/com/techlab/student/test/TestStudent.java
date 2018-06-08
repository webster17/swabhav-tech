package com.techlab.student.test;

import java.io.IOException;
import com.techlab.student.StudentConsole;

public class TestStudent {
	public static void main(String args[]) throws IOException,
			ClassNotFoundException {
		StudentConsole studentConsole = new StudentConsole();
		studentConsole.startApp();
	}
}
