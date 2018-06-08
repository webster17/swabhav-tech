package com.techlabs.multipleinheritance;

import com.techlabs.multipleinheritance.Area;
import com.techlabs.multipleinheritance.Perimeter;

public class Circle implements Area, Perimeter {
	private int radious;

	public void setRadious(int pradious) {
		radious = pradious;
	}

	public int getRadious() {
		return radious;
	}

	public float calculateArea() {
		return (Area.pi * radious * radious);
	}

	public float calculatePerimeter() {
		return (2 * Perimeter.pi * radious);
	}
}
