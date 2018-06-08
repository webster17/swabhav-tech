package com.techlabs.account.test;

import com.techlabs.account.Account;

public class AccountTest {
	public static void main(String args[]) {
		Account acc1 = new Account(131, "Santosh Dangodra", 1500);
		System.out.println("Count is: " + acc1.getCount());
		System.out.println("Count is: " + Account.getHeadCount());
		
		Account acc2 = new Account(121, "Darshan Joshi");
		System.out.println("Count is: " + acc2.getCount());
		System.out.println("Count is: " + Account.getHeadCount()+"\n");

		printDetails(acc1);
		System.out.println("\n** Withdraw 1000 from Acc:131 **");
		acc1.withdraw(1000);
		printDetails(acc1);

		System.out.println();
		printDetails(acc2);
	
//		System.out.println("\n** Withdraw 300 from Acc:121 **");
//		acc2.withdraw(300);
//		printDetails(acc2);

		System.out.println("\n** Deposit 400 into Acc:121 **");
		acc2.deposit(400);
		printDetails(acc2);
		
		System.out.println("\n** Withdraw 300 from Acc:121 **");
		acc2.withdraw(300);
		printDetails(acc2);
		
		System.out.println("\nNo's of deposit across all the object: "+Account.getCountDeposit());
		System.out.println("No's of withdraw across all the object: "+Account.getCountWithdraw());
	}

	public static void printDetails(Account acc) {
		System.out.println("Account No: " + acc.getAccNo());
		System.out.println("Name: " + acc.getName());
		System.out.println("Balance: " + acc.getBalance());
	}
}
