package com.techlabs.account;

import java.util.ArrayList;
import java.util.List;
import com.techlabs.accountlistener.IAccountListener;

public class Account {
	private int accNo;
	private double balance;
	private List<IAccountListener> iAccountListeners;

	public Account(int accNo, double balance) {
		this.accNo = accNo;
		this.balance = balance;
		this.iAccountListeners = new ArrayList<IAccountListener>();
	}

	public void deposit(double amount) {
		this.balance = balance + amount;
		notifyViaAllAccountListeners();
	}

	public void attach(IAccountListener iAccountListener) {
		iAccountListeners.add(iAccountListener);
	}

	public void notifyViaAllAccountListeners() {
		System.out.println("Successfully your deposit has been done!");
		for (IAccountListener iAccountListener : iAccountListeners) {
			iAccountListener.balanceChanged(this);
		}
	}

	public int getAccNo() {
		return accNo;
	}

	public double getBalance() {
		return balance;
	}
}