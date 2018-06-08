package com.techlabs.automobile.bmw;
import com.techlabs.automobile.IAutomibile;

public class BMWSedan implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("BMWFactory::BMWSedan() start!");
	}

	@Override
	public void stop() {
		System.out.println("BMWFactory::BMWSedan() stop!");
	}
}
