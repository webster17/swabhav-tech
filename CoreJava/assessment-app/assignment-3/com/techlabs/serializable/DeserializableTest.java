package com.techlabs.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializableTest {
	private static ObjectInputStream objectInputStream;
	public static void main(String args[]) throws IOException, ClassNotFoundException{

		String defaultPath = "assignment-3//com//techlabs//serializable//";

		objectInputStream = new ObjectInputStream(
			new FileInputStream(defaultPath+"triangle-serialize.ser"));
		Triangle rectDeserialized = (Triangle) objectInputStream.readObject();
		System.out.println(rectDeserialized.getHeight());
		System.out.println(rectDeserialized.getBase());

	}
}