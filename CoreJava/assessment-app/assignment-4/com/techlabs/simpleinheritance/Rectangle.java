package com.techlabs.simpleinheritance;

public class Rectangle {
	private int length;
	private int width;

	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int calculateArea() {
		return length * width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}
}
