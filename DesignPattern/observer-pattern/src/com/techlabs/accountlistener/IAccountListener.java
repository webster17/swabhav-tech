package com.techlabs.accountlistener;

import com.techlabs.account.Account;

public interface IAccountListener {
	public void balanceChanged(Account account);
}
