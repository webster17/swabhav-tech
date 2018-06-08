package com.techlabs.automobile.test;

import com.techlabs.automobile.AutoType;
import com.techlabs.automobile.AutomobileFactory;
import com.techlabs.automobile.IAutomibile;

public class AutomobileFactoryTest {
	public static void main(String args[]) {
		IAutomibile iAutomibile1 = AutomobileFactory.make(AutoType.Audi);
		System.out.println(iAutomibile1.getClass());
		

		IAutomibile iAutomibile2 = AutomobileFactory.make(AutoType.Tesla);
		System.out.println(iAutomibile2.getClass());
		

		IAutomibile iAutomibile3 = AutomobileFactory.make(AutoType.BMW);
		System.out.println(iAutomibile3.getClass());
	}
}
