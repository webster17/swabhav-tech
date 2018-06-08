package com.techlabs.crudable.test;

import com.techlabs.crudable.CustomerDB;
import com.techlabs.crudable.DepartmentDB;
import com.techlabs.crudable.EmployeeDB;
import com.techlabs.crudable.ICrudable;

public class TestCrudable {

	public static void main(String args[]) {
		ICrudable ic;
		ic = new CustomerDB();
		doDBOperation(ic);
		ic = new DepartmentDB();
		doDBOperation(ic);
		ic = new EmployeeDB();
		doDBOperation(ic);
	}

	private static void doDBOperation(ICrudable ic) {
		System.out.println("DB Operation:");
		ic.create();
		ic.read();
		ic.update();
		ic.delete();
		System.out.println("");
	}
}
