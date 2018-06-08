package com.techlabs.player.test;

import com.techlabs.player.Player;

public class PlayerTest {
	public static void main(String args[]) {
		// caseStudy1();

		Player p1 = new Player(101, "A", 20);
		Player p2 = new Player(101, "A", 20);

		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));

		p1 = p2;
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
	}

	@SuppressWarnings("unused")
	private static void caseStudy1() {
		Player sachin = new Player(10, "Sachin", 45);
		Player virat = new Player(102, "Virat");

		System.out.println("Sachin ID: " + sachin.getId());
		System.out.println("Virat ID: " + virat.getId());
		System.out.println("Sachin: " + sachin.getName());
		virat.setAge(23);
		System.out.println("Virat Age: " + virat.getAge());

		Player elder = sachin.whoIsElder(virat);
		System.out.println("Elder Player is: " + elder.getName());

		System.out.println(sachin);
		System.out.println(sachin.toString());
	}
}
