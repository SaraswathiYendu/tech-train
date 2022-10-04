package com.strings.main;

import java.io.File;
 import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) throws Exception {
		/* File Handler */
		File file =new File("myfile.txt");
		
		PrintWriter pw = new PrintWriter(file);
		pw.println("hey Harry!!");
		pw.println("Welcome to java world");
		
		pw.close();
	}
}
