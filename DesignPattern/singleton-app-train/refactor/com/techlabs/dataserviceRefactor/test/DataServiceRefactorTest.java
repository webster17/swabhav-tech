package com.techlabs.dataserviceRefactor.test;

import com.techlabs.dataserviceRefactor.DataServiceRefactor;

public class DataServiceRefactorTest {
	public static void main(String args[]){
		DataServiceRefactor dataService1 = DataServiceRefactor.getInstance();
		dataService1.doWork();
		
		DataServiceRefactor dataService2  = DataServiceRefactor.getInstance();
		dataService2.doWork();
	}
}
