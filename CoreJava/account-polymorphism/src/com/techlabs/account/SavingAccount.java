package com.techlabs.account;

@SuppressWarnings("serial")
public class SavingAccount extends Account {

	private static final int MINBALANCE;

	static {
		MINBALANCE = 500;
	}

	public int getMinBalance() {
		return MINBALANCE;
	}

	public SavingAccount(String name, double balance) {
		super(name, balance);
	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount >= MINBALANCE) {
			balance -= amount;
		} else {
			throw new BalanceException(
					"Insufficient balance! Minimum balance must be "
							+ MINBALANCE);
		}
	}

}
