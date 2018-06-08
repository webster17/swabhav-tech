package com.techlabs.readwritefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
	private FileReader fileReader;
	private BufferedReader bufferReader;
	private FileWriter fileWriter;
	private final String defaultPath = "assignment-3//com//techlabs//readwritefile//";

	public String readFile(String fileName) throws IOException {
		fileReader = new FileReader(defaultPath + fileName);
		bufferReader = new BufferedReader(fileReader);

		String currentLine = "", fileText = "";

		while ((currentLine = bufferReader.readLine()) != null) {
			fileText = fileText + currentLine + "\n";
		}
		bufferReader.close();
		fileReader.close();
		return fileText;
	}

	public void writeFile(String fileName, String fileContent)
			throws IOException {
		fileWriter = new FileWriter(defaultPath + fileName);
		fileWriter.write(fileContent);
		fileWriter.close();
	}

	public void copyFile(String readFileName, String writeFileName)
			throws IOException {
		fileReader = new FileReader(defaultPath + readFileName);
		bufferReader = new BufferedReader(fileReader);
		fileWriter = new FileWriter(defaultPath + writeFileName);

		String currentLine = "";

		while ((currentLine = bufferReader.readLine()) != null) {
			fileWriter.write(currentLine + "\n");
		}
		bufferReader.close();
		fileReader.close();
		fileWriter.close();
	}
}