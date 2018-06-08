package com.techlabs.automobile.audi;

import com.techlabs.automobile.IAutomibile;

public class AudiHatchBack implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("AudiFactory::AudiHatchBack() start!");
	}

	@Override
	public void stop() {
		System.out.println("AudiFactory::AudiHatchBack() stop!");
	}
}
