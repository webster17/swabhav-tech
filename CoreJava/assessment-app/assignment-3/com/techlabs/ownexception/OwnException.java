package com.techlabs.ownexception;

public class OwnException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	OwnException(String message) {
		super(message);
	}
}
