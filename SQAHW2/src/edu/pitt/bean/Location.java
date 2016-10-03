package edu.pitt.bean;

import java.util.Random;

public enum Location {

	CathedralLearning("The Cathedral of Learning", 1), SquirrelHill("Squirrel Hill", 2), ThePoint("The Point",
			3), Downtown("Downtown", 4);

	private String name;
	private int index;

	private Location(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static String getName(int index){
		for(Location location: Location.values()){
			if(location.getIndex() == index){
				return location.getName();
			}
		}
		return null;
		
	}
}
