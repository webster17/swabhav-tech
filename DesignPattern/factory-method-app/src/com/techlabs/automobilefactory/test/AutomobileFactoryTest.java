package com.techlabs.automobilefactory.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.techlabs.autofactory.*;
import com.techlabs.automobile.IAutomibile;

public class AutomobileFactoryTest {
	public static void main(String args[]) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String packageLine, packageName, filePath="src//com//techlabs//resources//factory.properties";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		packageLine = bufferedReader.readLine();
		packageName = packageLine.substring(packageLine.indexOf('=')+1, packageLine.indexOf(';')).trim();
		
		IAutoFactory factory = (IAutoFactory) Class.forName(packageName).newInstance();
		
		//IAutoFactory factory = new BMWFactory();
		IAutomibile iAutomibile = factory.make();
		
		iAutomibile.start();
		iAutomibile.stop();
		
	}
}
