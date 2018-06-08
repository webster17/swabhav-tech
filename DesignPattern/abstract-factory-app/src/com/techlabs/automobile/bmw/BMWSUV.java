package com.techlabs.automobile.bmw;
import com.techlabs.automobile.IAutomibile;

public class BMWSUV implements IAutomibile{

	@Override
	public void start() {
		System.out.println("BMWFactory::BMWSUV() start!");
	}

	@Override
	public void stop() {
		System.out.println("BMWFactory::BMWSUV() stop!");
	}	
}