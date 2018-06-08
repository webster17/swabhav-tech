package com.techlabs.accountlistener;

import com.techlabs.account.Account;

public class SMSAccountListener implements IAccountListener {

	@Override
	public void balanceChanged(Account account) {
		System.out.println("You will get notified via SMS");
		System.out.println("SMS: Your Account: " + account.getAccNo()
				+ " balance has been changed. Your new Current Balance is: "
				+ account.getBalance());
	}

}