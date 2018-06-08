package com.techlabs.factories.test;

import com.techlabs.factories.IAutoFactory;
import com.techlabs.factories.audi.AudiFactory;
import com.techlabs.factories.bmw.BMWFactory;
import com.techlabs.factories.tesla.TeslaFactory;

public class TestFactory {
	public static void main(String args[]) {

		displayFactory(AudiFactory.getInstance());
		displayFactory(BMWFactory.getInstance());
		displayFactory(TeslaFactory.getInstance());
	}

	public static void displayFactory(IAutoFactory factory) {

		factory.makeSUV().start();
		factory.makeSUV().stop();
		factory.makeSedan().start();
		factory.makeSedan().stop();
		factory.makeHatchBack().start();
		factory.makeHatchBack().stop();
	}
}
