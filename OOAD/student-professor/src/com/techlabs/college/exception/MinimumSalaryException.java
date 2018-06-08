package com.techlabs.college.exception;

@SuppressWarnings("serial")
public class MinimumSalaryException extends RuntimeException {
	public MinimumSalaryException(String errorMessage) {
		super(errorMessage);
	}
}
