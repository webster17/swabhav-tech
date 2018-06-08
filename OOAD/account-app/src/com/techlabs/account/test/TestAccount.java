package com.techlabs.account.test;

import com.techlabs.account.Account;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAccount {
		
		
		Account acc2 = new Account(121, "Darshan Joshi");
		
		@Test
		public void testWithdraw(){
			Account acc1 = new Account(131, "Santosh Dangodra", 1500);
			acc1.withdraw(1000);
			double expected = 400, actual = acc1.getBalance();
			
			//assertEquals(expected, actual);
		}
}
