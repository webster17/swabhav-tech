package com.techlabs.simpleinheritance;

import com.techlabs.simpleinheritance.Rectangle;

public class BlackBoard extends Rectangle {

	private int height;
	private String colour;

	public void setHeight(int height) {
		this.height = height;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getHeight() {
		return height;
	}

	public String getColour() {
		return colour;
	}

	public int calculateVolume() {
		return getLength() * getWidth() * height;
	}

}