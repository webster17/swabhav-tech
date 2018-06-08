package com.techlabs.college.exception;

@SuppressWarnings("serial")
public class PersonNotFoundException extends RuntimeException {
	public PersonNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
