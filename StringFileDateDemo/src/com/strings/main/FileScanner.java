package com.strings.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScanner {
	public static void main(String[] args) throws FileNotFoundException {
		/* File Handler */
		File file =new File("myfile.txt");
		
		/* Reading line by line */
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}
