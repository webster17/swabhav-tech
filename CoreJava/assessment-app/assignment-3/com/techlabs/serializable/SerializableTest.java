package com.techlabs.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableTest {


	static ObjectOutputStream objectOutputStream;
	public static void main(String args[]) throws IOException {
		String defaultPath = "assignment-3//com//techlabs//serializable//";
		
		Triangle triangle = new Triangle();
		triangle.setHeight(3);
		triangle.setBase(5);

		objectOutputStream = new ObjectOutputStream(new FileOutputStream(defaultPath+"triangle-serialize.ser"));
		System.out.println("Successfully serialization file is generated.");
		objectOutputStream.writeObject(triangle);
		objectOutputStream.close();
	}
}