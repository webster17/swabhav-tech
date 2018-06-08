package com.techlabs.account;

@SuppressWarnings("serial")
public abstract class Account extends BalanceException {

	private final int accNo;
	private final String name;
	protected double balance;
	private static int autoIncrement;

	static {
		autoIncrement = 0;
	}

	Account(String name, double balance) {
		super("Balance checking!");
		this.accNo = autoIncrement+1;
		this.name = name;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public abstract void withdraw(double amount);
}
