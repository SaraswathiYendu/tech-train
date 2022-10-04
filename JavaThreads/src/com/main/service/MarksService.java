package com.main.service;

import java.util.concurrent.Callable;

public class MarksService implements Callable<Double>{
	private double marks;

	public MarksService(double marks) {
		super();
		this.marks = marks;
	}

	@Override
	public Double call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		double percent = (this.marks * 100) / 400; 
		return percent;
	} 
}
