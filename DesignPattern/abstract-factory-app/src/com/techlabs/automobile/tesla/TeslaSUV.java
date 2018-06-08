package com.techlabs.automobile.tesla;

import com.techlabs.automobile.IAutomibile;

public class TeslaSUV implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("TeslaFactory::TeslaSUV() start!");
	}

	@Override
	public void stop() {
		System.out.println("TeslaFactory::TeslaSUV() stop!");
	}
}
