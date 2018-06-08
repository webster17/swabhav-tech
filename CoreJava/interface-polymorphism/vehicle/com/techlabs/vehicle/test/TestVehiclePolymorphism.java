package com.techlabs.vehicle.test;

import com.techlabs.vehicle.Bike;
import com.techlabs.vehicle.Car;
import com.techlabs.vehicle.IMovable;
import com.techlabs.vehicle.Truck;

public class TestVehiclePolymorphism {
	public static void main(String args[]) {
		IMovable imovables[] = new IMovable[5];
		imovables[0] = new Car(); 
		imovables[1] = new Truck(); 
		imovables[2] = new Car(); 
		imovables[3] = new Bike(); 
		imovables[4] = new Car(); 
		startRacing(imovables);
		
	}

	private static void startRacing(IMovable[] movables) {
		System.out.println("Start");
		for(IMovable movable:movables){
			movable.move();
		}
		System.out.println("Stop\n");
	}

}
