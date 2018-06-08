package com.techlabs.circle;

import com.techlabs.circle.BorderStyleOption.borderStyles;

public class Circle {
	private final float radious;
	private borderStyles borderStyle;

	public Circle(float pradious) {
		radious = pradious;
		borderStyle = borderStyles.SIGLE;
	}

	public Circle(float pradious, borderStyles pborderStyle) {
		radious = pradious;
		borderStyle = pborderStyle;
	}

	public float getRadius() {
		return radious;
	}

	public borderStyles getBorderStyle() {
		return borderStyle;
	}

	public float calculateArea() {
		return (float) (3.14 * radious * radious);
	}
}