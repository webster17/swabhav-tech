package com.techlabs.account.logger;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.techlabs.account.IAccountable;

public class AccountLoger implements IAccountable {

	protected IAccountable adderIAccountable;

	public AccountLoger(IAccountable adderIAccountable) {
		this.adderIAccountable = adderIAccountable;
	}

	@Override
	public void deposit(double amount) {
		System.out.println("Before Deposit add time: "
				+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
						.format(new Date()));
		adderIAccountable.deposit(amount);
		System.out.println("After deposit add time: "
				+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
						.format(new Date()));

	}
}
