package com.strings.main;

import java.io.BufferedReader;
import java.io.File;
 import java.io.FileReader;
import java.io.IOException;

public class BufferredReaderDemo {
	public static void main(String[] args) throws IOException {
		/* File Handler */
		File file =new File("myfile.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		System.out.println(br.readLine());
		br.close();
	}
}
