package com.techlabs.serializable;

import java.io.Serializable;

public class Triangle implements Serializable {
	private static final long serialVersionUID = 1L;
	private int base;
	private int height;

	public void setBase(int base) {
		this.base = base;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public int getBase() {
		return base;
	}

	public float calculateArea() {
		return (float) (0.5 * base * height);
	}
}
