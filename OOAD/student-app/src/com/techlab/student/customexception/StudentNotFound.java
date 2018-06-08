package com.techlab.student.customexception;

@SuppressWarnings("serial")
public class StudentNotFound extends RuntimeException{
	public StudentNotFound(String s) {
		super(s);
	}
}
