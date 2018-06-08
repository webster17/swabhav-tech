package com.techlabs.account;

public class BalanceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	BalanceException(String message) {
		super(message);
	}
}
