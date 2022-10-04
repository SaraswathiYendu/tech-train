package com.java8.main;

public class A{
	public void showMessage(Inter i) {
		//call display of interface Inter
		i.display();
	}
	
	public void greetEmployee(Greetings s, Employee e) {
		s.greet(e);
	}
}
