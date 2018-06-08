package com.techlabs.automobile.audi;

import com.techlabs.automobile.IAutomibile;

public class AudiSedan implements IAutomibile{

	@Override
	public void start() {
		System.out.println("BMWFactory::AudiSedan() start!");
	}

	@Override
	public void stop() {
		System.out.println("BMWFactory::AudiSedan() stop!");
	}
}
