package com.techlabs.automobile.tesla;

import com.techlabs.automobile.IAutomibile;

public class TeslaHatchBack implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("TeslaFactory::TeslaHatchBack() start!");
	}

	@Override
	public void stop() {
		System.out.println("TeslaFactory::TeslaHatchBack() stop!");
	}
}
