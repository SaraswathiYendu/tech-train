package com.strings.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		/* File Handler */
		File file =new File("myfile.txt");
		
		/* Create a file using file handler */
		file.createNewFile();
		
		/* Write the data in the file */
		FileWriter fw = new FileWriter("myfile1.txt"); //new file will be created
		
		FileWriter fw1 = new FileWriter(file); //work with existing file
		
		fw.write("hello world");
		fw1.write("hello world 1");
		System.out.println("file operation complete..");
		fw.close();
		fw1.close();
	}
}
