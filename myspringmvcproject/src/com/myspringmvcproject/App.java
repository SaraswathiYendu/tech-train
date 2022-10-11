package com.myspringmvcproject;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class App extends AbstractAnnotationConfigDispatcherServletInitializer{
	/* Spring says, if you can make this App as your DispatcherServlet class then,
	   I will make this as my first point of execution of project   */
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] carry = new Class[] {ControllerConfig.class};
		return carry;
	}

	@Override
	protected String[] getServletMappings() {
		String[] sarry = new String[] {"/"};
		return sarry;
	}

	}

/*
	Animal <abstract>
	
	Dog extends Animal : Dog is-a Animal
*/