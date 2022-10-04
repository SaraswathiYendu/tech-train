package com.strings.main;

import java.io.File;
 
import java.io.FileReader;
import java.io.IOException;
 
import java.util.Scanner;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		/* File Handler */
		File file =new File("myfile.txt");
		
		/* Reading char by char */
		FileReader fr = new FileReader("myfile1.txt");
		char[] arry = new char[100];
		fr.read(arry);
		for( char c: arry) {
			System.out.print(c);
		}
		fr.close();
		 
	}
}
