package com.strings.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenDemo {
	public static void main(String[] args) throws FileNotFoundException {
		String vendors="";
		
		/* File Handler */
		File file =new File("vendors.txt");
		
		/* Reading line by line */
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			vendors = sc.nextLine();
		}
		
		sc.close();
		
		System.out.println(vendors);
		
		StringTokenizer token = new StringTokenizer(vendors);
		System.out.println("No of vendors: " + token.countTokens());
		String[] vendorArry = new String[token.countTokens()];
		int i=0;
		while(token.hasMoreTokens()) {
			vendorArry[i++] = token.nextToken();
		}
		
		for(String v : vendorArry) {
			System.out.println(v);
		}
		
		/* Intercepting the URL */
		String url="http://www.example.com";
		StringTokenizer urlToken = new StringTokenizer(url,"://.");
		System.out.println(urlToken.countTokens());
		
		String[] urlArry = new String[urlToken.countTokens()];
		int j=0;
		while(urlToken.hasMoreTokens()) {
			urlArry[j++] = urlToken.nextToken();
		}
		System.out.println("DB Friendly Domain: " + urlArry[2] + "." + urlArry[3]);
		
		String str="10 apples 20 mangoes";
		String[] sarry = str.split("\\d");   //d=[0-9] s=" "
		for(String s : sarry ) {
			System.out.println(s);
		}
	}
}
