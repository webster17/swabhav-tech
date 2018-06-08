package com.techlabs.player;

public class Player {

	private int id, age;
	private String name;

	public Player(int id, String name) {
		this(id, name, 18);
	}

	public Player(int id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\tName: " + name + "\tAge: " + age;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.id == ((Player) obj).getId());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Player whoIsElder(Player player) {
		return (this.age > player.age) ? this : player;
	}
}
