package com.techlabs.custom.exceptions;

@SuppressWarnings("serial")
public class CellAlreadyMarkedException extends Exception {
	public CellAlreadyMarkedException(String message) {
		super(message);
	}
}
