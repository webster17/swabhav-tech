package com.techlabs.account;

public class Account implements IAccountable {

	int accNo;
	String name;
	double balance;

	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
	}

	@Override
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("New amount is: "+getBalance());
	}
	
	private double getBalance(){
		return balance;
	}

}
