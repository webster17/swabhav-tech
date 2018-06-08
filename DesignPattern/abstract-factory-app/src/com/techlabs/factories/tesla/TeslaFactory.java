package com.techlabs.factories.tesla;

import com.techlabs.automobile.IAutomibile;
import com.techlabs.automobile.tesla.TeslaHatchBack;
import com.techlabs.automobile.tesla.TeslaSUV;
import com.techlabs.automobile.tesla.TeslaSedan;
import com.techlabs.factories.IAutoFactory;

public class TeslaFactory implements IAutoFactory {

	private static TeslaFactory teslaFactory;
	
	public static IAutoFactory getInstance(){
		if(teslaFactory == null)
			teslaFactory = new TeslaFactory();
		return teslaFactory;
	}

	@Override
	public IAutomibile makeSUV() {
		return new TeslaSUV();
	}

	@Override
	public IAutomibile makeSedan() {
		return new TeslaSedan();
	}

	@Override
	public IAutomibile makeHatchBack() {
		return new TeslaHatchBack();
	}
}
