package com.techlabs.account;

public class Account {
	private static final int MINBALANCE;
	private static int count, countDeposit, countWithdraw;
	private final int accNo;
	private final String name;
	private double balance;

	static {
		count = 0;
		countDeposit = 0;
		countWithdraw = 0;
		System.out.println("count is: " + count);
		MINBALANCE = 500;
	}

	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		count += 1;
	}


	public Account(int accNo, String name) {
		this(accNo, name, 500);
	}

	public int getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public int getCount() {
		return count;
	}

	public static int getHeadCount() {
		return count;
	}

	public static int getMinBalance() {
		return MINBALANCE;
	}
	
	public static int getCountDeposit(){
		return countDeposit;
	}
	
	public static int getCountWithdraw(){
		return countWithdraw;
	}

	public void deposit(double amount) {
		balance += amount;
		countDeposit += 1;
	}

	public void withdraw(double amount) {
		if (balance - amount >= MINBALANCE) {
			balance -= amount;
			countWithdraw += 1;
		} else {
			throw new InsufficientFundException(this, amount);
		}
	}
}
