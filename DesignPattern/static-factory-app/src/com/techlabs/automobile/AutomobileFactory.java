package com.techlabs.automobile;

public class AutomobileFactory {
	private static IAutomibile iAutomibile;
	
	public static IAutomibile make(AutoType autoType){
		
		if(autoType == AutoType.Audi)
			iAutomibile = new BMW();
		else if(autoType == AutoType.Tesla)
			iAutomibile = new Tesla();
		else if(autoType == AutoType.Audi)
			iAutomibile = new Audi();
		
		return iAutomibile;
	}
}