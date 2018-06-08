package com.techlabs.accountlistener;

import com.techlabs.account.Account;

public class EmailAccountListener implements IAccountListener {

	@Override
	public void balanceChanged(Account account) {

		System.out.println("You will get notified via Email");
		System.out.println("Email: Your Account: " + account.getAccNo()
				+ " balance has been changed. Your new Current Balance is: "
				+ account.getBalance());
	}

}