package com.strings.main;

public class StringFunctionsAndBuilder {
	public static void main(String[] args) {
		 // StringBuilder sb1 = ""; <- cannot create a literal of StringBuilder
		
		StringBuilder sb1 = new StringBuilder("harry");
		StringBuilder sb2 = new StringBuilder("harry");
		
		/* StringBuilders should not be used for comparision */
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1 == sb2);
		
		/* Convert into String and then compare */
		System.out.println(sb1.toString().equals(sb2.toString()));//true
		
		/*StringBuilder can perform operations on String values much faster as it works
		 on same location, no other object is created. */
		
		sb1 = sb1.append(" potter")
				.insert(0, "Mr. ")
				.append(" hogwards")
				.replace(17, 25, "london");
		System.out.println(sb1);

		String fname="harry";
		String lname="potter";
		String mname="james";
		String title="mr";
		
		StringBuilder name = 
				new StringBuilder(fname.toUpperCase())
				.append(" ")
				.append(mname.toUpperCase())
				.append(" ")
				.append(lname.toUpperCase())
				.insert(0,title.toUpperCase() + ". ");
		System.out.println(name);
	}
}
