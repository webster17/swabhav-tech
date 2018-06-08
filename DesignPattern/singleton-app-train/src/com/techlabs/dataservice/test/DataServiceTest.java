package com.techlabs.dataservice.test;

import com.techlabs.dataservice.DataService;

public class DataServiceTest {
	public static void main(String args[]){
		DataService dataService1 = DataService.getInstance();
		dataService1.doWork();
		
		DataService dataService2  = DataService.getInstance();
		dataService2.doWork();
	}
}
