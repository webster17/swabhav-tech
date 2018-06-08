package com.techlabs.constructor.inheritance.test;

import com.techlabs.constructor.inheritance.Child;

public class TestConstructorInheritance {
	public static void main(String args[]){
		Child child1 = new Child();
		System.out.println(child1.getFoo());
		Child child2 = new Child();
		System.out.println(child2.getFoo());
		Child child3 = new Child(100);
		System.out.println(child3.getFoo());
		Child child4 = new Child(200);
		System.out.println(child4.getFoo());
	}
}
