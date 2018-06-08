package com.techlabs.autofactory;

import com.techlabs.automobile.BMW;
import com.techlabs.automobile.IAutomibile;

public class BMWFactory implements IAutoFactory {

	private static BMWFactory bmwFactory;

	@Override
	public IAutomibile make() {
		return new BMW();
	}
	
	public static IAutoFactory getInstance(){
		if(bmwFactory == null)
			bmwFactory = new BMWFactory();
		return bmwFactory;
	}
}
