package com.java8.main;

public class App {
	public static void main(String[] args) {
		A a= new A(); 
		a.showMessage( () -> {
			System.out.println("hello Lambda!!");
		});
		
		Employee emp=new Employee(); 
		emp.setId(1);
		emp.setName("harry");
		emp.setBranch("IT");
		a.greetEmployee( (Employee e) -> {
			System.out.println("hello " + e.getName() + ". Your are in "+ e.getBranch() + " branch" );
		}, emp);
		
	}
	 
}