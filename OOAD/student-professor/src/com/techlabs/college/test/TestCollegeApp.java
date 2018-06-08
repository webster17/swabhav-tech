package com.techlabs.college.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.techlabs.college.CollegeAppConsole;

public class TestCollegeApp {
	public static void main(String args[]) throws FileNotFoundException, ClassNotFoundException, IOException, ParseException {
		CollegeAppConsole collegeApp = new CollegeAppConsole();
		collegeApp.start();
	}
}
