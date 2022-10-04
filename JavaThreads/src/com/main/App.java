package com.main;

import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "-- hello");
		
		 A a=new A();
		 a.start(); //Thread-0
		 
		 B b=new B();
		 b.start(); //Thread-1
		 
		 try {
			a.join();
			b.join();
		} catch (InterruptedException e) {}
		 
		System.out.println("hey some other operation after count is done");
		
		//Second Example
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.parallelStream().forEach(n-> System.out.print(n + " ") );

	}
}

class A extends Thread{ // A is-a Thread 
	
	@Override
	public void run() {
		countIncr();
	}
	
	void countIncr() {
		System.out.println(Thread.currentThread().getName());
		int count =0; 
		for(int i=0;i<1000000;i++) {
			count++;
		}
		System.out.println("count = " + count);
	}
}

class B extends Thread{
	@Override
	public void run() {
		numIncr();
	}
	
	void numIncr() {
		System.out.println(Thread.currentThread().getName());
		int num =0; 
		for(int i=0;i<1000000;i++) {
			num++;
		}
		System.out.println("num = " + num);
	}
}
