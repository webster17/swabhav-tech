package com.techlabs.singleton.test;

import com.techlabs.singleton.Singleton;

public class TestSingleton {

	public static void main(String args[]) {
		Singleton instance = Singleton.getInstance();

		instance.displayMessage();
	}
}