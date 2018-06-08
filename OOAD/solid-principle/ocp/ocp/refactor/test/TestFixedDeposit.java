package ocp.refactor.test;

import ocp.refactor.NewYear;
import ocp.refactor.FixedDeposit;

public class TestFixedDeposit {
	public static void main(String args[]){
		FixedDeposit fixedDeposit=new FixedDeposit(8675345, "Santosh", 100000, 8, new NewYear());
		System.out.println("Account No\t: "+fixedDeposit.getAccountNo());
		System.out.println("Name\t\t: "+fixedDeposit.getName());
		System.out.println("Interest\t: "+fixedDeposit.calculateTotalIntrest());
		System.out.println("Principle after 8 years: "+(fixedDeposit.getPrinciple()+fixedDeposit.calculateTotalIntrest()));;
	}
}
