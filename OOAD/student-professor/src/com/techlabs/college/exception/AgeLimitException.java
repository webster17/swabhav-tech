package com.techlabs.college.exception;

@SuppressWarnings("serial")
public class AgeLimitException extends RuntimeException {
	public AgeLimitException(String errorMessage) {
		super(errorMessage);
	}
}
