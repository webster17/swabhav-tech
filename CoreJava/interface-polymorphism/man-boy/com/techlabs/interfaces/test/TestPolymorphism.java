package com.techlabs.interfaces.test;

import com.techlabs.interfaces.Boy;
import com.techlabs.interfaces.IEmotionable;
import com.techlabs.interfaces.IMannerable;
import com.techlabs.interfaces.Man;

public class TestPolymorphism {
	
	public static void main(String args[]){
		Man man=new Man();
		Boy boy = new Boy();
		
		atTheParty(man);
		atTheParty(boy);
		atTheMovie(boy);
//		atTheMovie(man);
	}
	
	private static void atTheParty(IMannerable mannerable){
		System.out.println("At the Party");
		mannerable.wish();
		mannerable.depart();
		System.out.println("");
	}
	private static void atTheMovie(IEmotionable emotionable){
		System.out.println("At the Movie");
		emotionable.cry();
		emotionable.laugh();
		System.out.println("");
	}
}
