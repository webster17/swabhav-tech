package com.techlabs.readwritefile;

import java.io.IOException;

public class ReadWriteFileTest {
	public static void main(String args[]) throws IOException {
		ReadWriteFile rwf = new ReadWriteFile();
		String fileContent = rwf.readFile("read.txt");
		System.out.println("FileContent: \n" + fileContent);
		rwf.writeFile("write.txt", fileContent);
		rwf.copyFile("read.txt", "copy.txt");
	}
}