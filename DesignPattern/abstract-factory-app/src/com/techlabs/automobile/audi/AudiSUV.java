package com.techlabs.automobile.audi;

import com.techlabs.automobile.IAutomibile;

public class AudiSUV implements IAutomibile{
	
	@Override
	public void start() {
		System.out.println("AudiFactory::AudiSUV() start!");
	}

	@Override
	public void stop() {
		System.out.println("AudiFactory::AudiSUV() stop!");
	}
}
