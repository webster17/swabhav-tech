package com.techlabs.automobile.tesla;

import com.techlabs.automobile.IAutomibile;

public class TeslaSedan implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("TeslaFactory::TeslaSedan() start!");
	}

	@Override
	public void stop() {
		System.out.println("TeslaFactory::TeslaSedan() stop!");
	}
}
