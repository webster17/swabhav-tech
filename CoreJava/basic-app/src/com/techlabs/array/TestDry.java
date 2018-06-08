package com.techlabs.array;

class Area{
	private int height, width;
	private float area;
	
	public void getData(int height, int width){
		this.height = height;
		this.width = width;
	}
	
	public void calculateTriangleArea(){
		area = (float) (0.5 * height* width);
		displayArea("Triangle");
	}
	
	public void calculateRectangleArea(){
		area = height * width;
		displayArea("Rectangle");
	}
	
	public void displayArea(String shape){
		System.out.println("Area of "+shape+" is: "+area);
	}
	
}

public class TestDry {
	public static void main(String args[]){
		Area a = new Area();
		a.getData(15, 25);
		a.calculateRectangleArea();
		a.calculateTriangleArea();
	}
}
