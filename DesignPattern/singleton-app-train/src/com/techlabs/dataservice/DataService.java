package com.techlabs.dataservice;

public class DataService {
	
	private DataService(){
		System.out.println("Service cerated!");
	}
	
	public static DataService getInstance(){
		return new DataService();
	}
	
	public void doWork(){
		System.out.println("Service working with id "+hashCode());
	}
}
