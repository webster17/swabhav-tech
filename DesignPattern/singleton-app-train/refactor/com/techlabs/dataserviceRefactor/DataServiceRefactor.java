package com.techlabs.dataserviceRefactor;

public class DataServiceRefactor {
	
	static private DataServiceRefactor dataServiceRefactor;
	private DataServiceRefactor(){
		System.out.println("Service cerated  !");
	}
	
	public static DataServiceRefactor getInstance(){
		if(dataServiceRefactor == null)
		dataServiceRefactor = new DataServiceRefactor();
		
		return dataServiceRefactor ;
	}
	
	public void doWork(){
		System.out.println("Service working with id "+hashCode());
	}
}