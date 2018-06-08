package com.techlabs.factories.bmw;

import com.techlabs.automobile.bmw.BMWSUV;
import com.techlabs.automobile.bmw.BMWSedan;
import com.techlabs.automobile.IAutomibile;
import com.techlabs.automobile.bmw.BMWHatchBack;
import com.techlabs.factories.IAutoFactory;

public class BMWFactory implements IAutoFactory {

	private static BMWFactory bmwFactory;
	
	public static IAutoFactory getInstance(){
		if(bmwFactory == null)
			bmwFactory = new BMWFactory();
		return bmwFactory;
	}

	@Override
	public IAutomibile makeSUV() {
		return new BMWSUV();
	}

	@Override
	public IAutomibile makeSedan() {
		return new BMWSedan();
	}

	@Override
	public IAutomibile makeHatchBack() {
		return new BMWHatchBack();
	}
}
