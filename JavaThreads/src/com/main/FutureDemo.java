package com.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.main.service.MarksService;

public class FutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Double[] smarks = {244d,344d,256d,389d,375d,310d,324d,278d,204d};
		Future<Double>[] futureArry = new Future[smarks.length];
		/* This service will maintain 4 threads  */
		ExecutorService service =  Executors.newFixedThreadPool(4); 
		
		for(int i=0;i<smarks.length;i++) {
			futureArry[i] = service.submit(new MarksService(smarks[i]));
		}
		
		for(Future<Double> f : futureArry) {
			System.out.print(f.get() + "  ");
		}
		
		/* shuts down all the threads in the pool */
		service.shutdown();
	}
}
