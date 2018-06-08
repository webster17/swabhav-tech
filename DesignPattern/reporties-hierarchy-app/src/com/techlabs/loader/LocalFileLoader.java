package com.techlabs.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LocalFileLoader implements ILoadable {
	
	private String filePath;
	private BufferedReader bufferedReader;
	
	public LocalFileLoader(String filePath){
		this.filePath = filePath;
	}
	
	@Override
	public String fileContentReader() throws IOException {
		String currentLine="",fileContent="";
		bufferedReader = new BufferedReader(new FileReader(filePath));
		while ((currentLine = bufferedReader.readLine()) != null) {
			fileContent = fileContent + currentLine+"\n";
		}
		return fileContent;
	}
}