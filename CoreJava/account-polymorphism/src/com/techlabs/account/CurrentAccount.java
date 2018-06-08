package com.techlabs.account;

@SuppressWarnings("serial")
public class CurrentAccount extends Account {

	private static final int MAXOVERDRAFT;

	static {
		MAXOVERDRAFT = 5000;
	}

	public int getMaxOverdraft() {
		return MAXOVERDRAFT;
	}

	public CurrentAccount(String name, double balance) {
		super(name, balance);
	}

	@Override
	public void withdraw(double amount) {
		if (balance + amount <= balance + MAXOVERDRAFT) {
			balance -= amount;
		} else {
			throw new BalanceException(
					"Overdraft limit exceeded! Maximum Overdraft limit is "
							+ MAXOVERDRAFT);
		}
	}

}
