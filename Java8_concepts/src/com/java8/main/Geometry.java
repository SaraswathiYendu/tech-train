package com.java8.main;

public interface Geometry {
	void m1();
	default void m2() {
		System.out.println("this is m2");
	}
}
//A implements Geometry 
//A a=new A(); a.m2() 