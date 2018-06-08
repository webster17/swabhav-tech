package com.techlabs.account;

public class CheckMinBalance extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	CheckMinBalance(String message) {
		super(message);
	}
}
