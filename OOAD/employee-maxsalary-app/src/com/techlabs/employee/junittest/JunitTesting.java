package com.techlabs.employee.junittest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.techlabs.loader.ILoadable;
import com.techlabs.loader.LocalFileLoader;
import com.techlabs.loader.WebFileLoader;
import com.techlabs.parser.CSVParser;
import com.techlabs.parser.IParser;

import static org.junit.Assert.*;

public class JunitTesting {
	
	private final String defaultPath = "src//com//techlabs//resources//";
	private BufferedReader bufferedReader;

	@Test
	public void checkWhetherLocalFileLoaderWorking1() throws FileNotFoundException, IOException{
		ILoadable iLoadable=new LocalFileLoader(defaultPath+"dataFile.txt");
		String currentLine="",fileContent="";
		bufferedReader = new BufferedReader(new FileReader(defaultPath+"dataFile.txt"));
		while ((currentLine = bufferedReader.readLine()) != null) {
			fileContent = fileContent + currentLine+"\n";
		}
		assertEquals(fileContent, iLoadable.fileContentReader());		
	}
	
	@Test
	public void checkWhetherLocalFileLoaderWorking() throws FileNotFoundException, IOException{
		ILoadable iLoadable=new WebFileLoader("https://swabhav-tech.firebaseapp.com/emp.txt");
		String currentLine="",fileContent="";
		bufferedReader = new BufferedReader(new FileReader(defaultPath+"emp.txt"));
		while ((currentLine = bufferedReader.readLine()) != null) {
			fileContent = fileContent + currentLine+"\n";
		}
		assertEquals(fileContent, iLoadable.fileContentReader());		
	}
	
	@Test
	public void checkWhetherCSVParserWorking() throws IOException, ParseException{
		IParser iParser = new CSVParser(new LocalFileLoader(defaultPath+"dataFile.txt"));
		bufferedReader = new BufferedReader(new FileReader(defaultPath+"dataFile.txt"));
		iParser.parseFile();
		//assertEquals(bufferedReader.readLine(), iParser.parseFile());
	}
}