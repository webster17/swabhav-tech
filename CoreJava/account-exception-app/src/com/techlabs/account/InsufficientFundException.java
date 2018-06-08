package com.techlabs.account;

public class InsufficientFundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Account account;
	private final double amount;

	InsufficientFundException(Account account, double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public String getMessage(){
		String message = "Error Message: Account no with "+account.getAccNo()+" has a balance "+ account.getBalance()+
				" which is not sufficient to withdraw " +amount;
		return message;
	}
}
