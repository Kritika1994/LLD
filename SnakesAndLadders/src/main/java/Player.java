package main.java;

public class Player {
	String name;
	static int ID;
	int id;
	int currPos;
	boolean locked;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrPos() {
		return currPos;
	}
	public void setCurrPos(int currPos) {
		this.currPos = currPos;
	}
	public Player(String name) {
		this.id = ID++;
		this.name = name;
		this.currPos = 0;
		locked=true;
		// TODO Auto-generated constructor stub
	}

}
