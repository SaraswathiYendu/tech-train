package com.strings.main;

public class App {
	public static void main(String[] args) {
		/* String Literal */
		String str = "harry potter";
		/* String Object */
		String s1 = new String("harry potter");
		
		/* String literals go in the pool, where as String objects go in the heap */
		
		String str1 = "harry potter";
		String s2 = new String("harry potter");
		
		/* equals(): compares values & == operator compares locations */
		
		System.out.println(str.equals(s1)); //harry potter = harry potter : true
		System.out.println(str1.equals(s2)); //true
		
		System.out.println(str == s1); //10X = 100X : false
		System.out.println(str == str1); //true
		
		/* NOTE: always use equals/equalsIgnoreCase for String comparision*/
		
		//String is IMMUTABLE
		str = "ronald weasley";
		System.out.println(str);
		System.out.println(str == str1); //false
	}
}



