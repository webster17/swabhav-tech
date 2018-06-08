package com.techlabs.autofactory;

import com.techlabs.automobile.IAutomibile;
import com.techlabs.automobile.Tesla;

public class TeslaFactory implements IAutoFactory {

	private static TeslaFactory teslaFactory;
	
	@Override
	public IAutomibile make() {
		return new Tesla();
	}

	public static IAutoFactory getInstance(){
		if(teslaFactory == null)
			teslaFactory = new TeslaFactory();
		return teslaFactory;
	}
}
