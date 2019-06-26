package model;

import sun.plugin2.message.Serializer;

import java.io.Serializable;

public class Player implements Serializable {
	private String name;
	private String surName;

	public Player(String name, String subName) {
		this.name = name;
		this.surName = subName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return surName;
	}

	public void setSubName(String subName) {
		this.surName = subName;
	}

	@Override
	public String toString() {
		return "Player{" +
				"name='" + name + '\'' +
				", subName='" + surName + '\'' +
				'}';
	}
}
