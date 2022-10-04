package com.java8.main;

public class Test {
	public static void main(String[] args) {
		A a=new A(); 
		a.showMessage(() -> {
			System.out.println("hello lambda test");
		});
		Employee emp=new Employee(); 
		emp.setId(1);
		emp.setName("harry");
		emp.setBranch("IT");
		a.greetEmployee(   (Employee e) -> {
			System.out.println("hello " + e.getName() + ". your ID is "+ e.getId());
		}, emp);
	}
	
	 
}
