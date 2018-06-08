package isp.refactor.test;

import isp.refactor.IEatable;
import isp.refactor.IWorkable;
import isp.refactor.Manager;
import isp.refactor.Robot;

public class TestRefactorISP {
	public static void main(String args[]) {
		Manager manager = new Manager();
		atTheWorkstation(manager);
		atTheCafeteria(manager);

		Robot robot = new Robot();
		atTheWorkstation(robot);
	}

	private static void atTheWorkstation(IWorkable iWorkable) {
		System.out.println("\nAt the WorkStation:");
		iWorkable.startWork();
		iWorkable.stopWork();
	}

	private static void atTheCafeteria(IEatable iEatable) {
		System.out.println("\nAt the Cafeteria:");
		iEatable.startEat();
		iEatable.stopEat();
	}
}