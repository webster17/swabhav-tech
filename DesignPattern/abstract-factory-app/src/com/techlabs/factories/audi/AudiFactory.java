package com.techlabs.factories.audi;

import com.techlabs.automobile.IAutomibile;
import com.techlabs.automobile.audi.AudiHatchBack;
import com.techlabs.automobile.audi.AudiSUV;
import com.techlabs.automobile.audi.AudiSedan;
import com.techlabs.factories.IAutoFactory;



public class AudiFactory implements IAutoFactory {

	private static AudiFactory audiFactory;
	
	public static IAutoFactory getInstance(){
		if(audiFactory == null)
			audiFactory = new AudiFactory();
		return audiFactory;
	}

	@Override
	public IAutomibile makeSUV() {
		return new AudiSUV();
	}

	@Override
	public IAutomibile makeSedan() {
		return new AudiSedan();
	}

	@Override
	public IAutomibile makeHatchBack() {
		return new AudiHatchBack();
	}
}
