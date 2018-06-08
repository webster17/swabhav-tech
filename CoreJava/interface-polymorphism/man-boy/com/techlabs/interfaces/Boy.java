package com.techlabs.interfaces;

public class Boy implements IMannerable, IEmotionable{

	@Override
	public void cry() {
		System.out.println("Crying");
	}

	@Override
	public void laugh() {
		System.out.println("Laughing");
	}

	@Override
	public void wish() {
		System.out.println("Good Morning");
	}

	@Override
	public void depart() {
		System.out.println("See You tommorow");
	}

}
