package com.techlabs.autofactory;

import com.techlabs.automobile.Audi;
import com.techlabs.automobile.IAutomibile;

public class AudiFactory implements IAutoFactory {

	private static AudiFactory audiFactory;
	
	@Override
	public IAutomibile make() {
		return new Audi();
	}
	
	public static IAutoFactory getInstance(){
		if(audiFactory == null)
			audiFactory = new AudiFactory();
		return audiFactory;
	}
}