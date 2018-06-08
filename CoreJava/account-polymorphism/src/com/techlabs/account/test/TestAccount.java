package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.account.CurrentAccount;
import com.techlabs.account.SavingAccount;

public class TestAccount {
	public static void main(String args[]){
		CurrentAccount currentAccount = new CurrentAccount("Santosh Dangodra", 2000);
		printDetails(currentAccount);
		
//		System.out.println("\n** Withdrow 9000 from Account **");
//		currentAccount.withdraw(9000);
//		printDetails(currentAccount);
		
		System.out.println("\n ** Withdraw 5000 from Account **");
		currentAccount.withdraw(5000);
		printDetails(currentAccount);
		
		System.out.println("\n ** Deposit 1000 into Account **");
		currentAccount.deposit(1000);
		printDetails(currentAccount);
		
		System.out.println();
		SavingAccount savingAccount = new SavingAccount("Darshan Joshi", 1000);
		printDetails(savingAccount);
		
//		System.out.println("\n** Withdrow 600 from Account **");
//		savingAccount.withdraw(600);
//		printDetails(savingAccount);
		
		System.out.println("\n ** Withdraw 200 from Account **");
		savingAccount.withdraw(200);
		printDetails(savingAccount);
		
		System.out.println("\n ** Deposit 2000 into Account **");
		savingAccount.deposit(2000);
		printDetails(savingAccount);
	}
	public static void printDetails(Account acc){
		System.out.println("-- Account Details --");
		System.out.println("Account No: "+acc.getAccNo());
		System.out.println("Name: "+acc.getName());
		System.out.println("Balance: "+acc.getBalance());
	}
}
