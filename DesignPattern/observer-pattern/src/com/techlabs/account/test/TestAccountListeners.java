package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.accountlistener.EmailAccountListener;
import com.techlabs.accountlistener.SMSAccountListener;

public class TestAccountListeners {
	public static void main(String args[]) {
		Account account = new Account(5001, 10000);
		account.attach(new SMSAccountListener());
		account.attach(new EmailAccountListener());
		account.deposit(5000);
	}
}