package isp.violation.test;

import isp.violation.IWorker;
import isp.violation.Manager;
import isp.violation.Robot;

public class TestISP {
	public static void main(String args[]){
		Manager manager=new Manager();
		atTheWorkstation(manager);
		atTheCafeteria(manager);
		
		Robot robot = new Robot();
		atTheWorkstation(robot);
		atTheCafeteria(robot);
	}
	
	private static void atTheWorkstation(IWorker iWorker){
		System.out.println("\nAt the WorkStation:");
		iWorker.startWork();
		iWorker.stopWork();
	}
	
	private static void atTheCafeteria(IWorker iWorker){
		System.out.println("\nAt the Cafeteria:");
		iWorker.startEat();
		iWorker.stopEat();
	}
}