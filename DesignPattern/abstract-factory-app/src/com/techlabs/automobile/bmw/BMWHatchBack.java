package com.techlabs.automobile.bmw;
import com.techlabs.automobile.IAutomibile;

public class BMWHatchBack implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("BMWFactory::BMWHatchBack() start!");
	}

	@Override
	public void stop() {
		System.out.println("BMWFactory::BMWHatchBack() stop!");
	}
}
