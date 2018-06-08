package com.techlabs.rectangle;

public class Rectangle {
	private int width, height;
	private String borderColour;

	public int calculateArea() {
		return height * width;
	}

	private int validateSide(int side) {
		if (side < 1)
			return 1;
		else if (side > 100)
			return 100;
		else
			return side;
	}

	private String validateColour(String colour) {
		if (colour.equalsIgnoreCase("Red") || colour.equalsIgnoreCase("Green")
				|| colour.equalsIgnoreCase("Blue"))
			return colour.substring(0, 1).toUpperCase()
					+ colour.substring(1).toLowerCase();
		else
			return "Red";
	}

	public void setHeight(int pheight) {
		height = validateSide(pheight);
	}

	public void setWidth(int pwidth) {
		width = validateSide(pwidth);
	}

	public void setBorderColour(String pcolour) {
		borderColour = validateColour(pcolour);
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public String getBorderColour() {
		return borderColour;
	}
}