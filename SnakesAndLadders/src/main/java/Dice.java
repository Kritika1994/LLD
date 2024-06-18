package main.java;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	int numDices ;
	Dice(int numDices){
		this.numDices = numDices;
	}
	public int rollDice() {
		
		int randomNum = ThreadLocalRandom.current().nextInt(numDices*1, numDices*6 + 1);
		System.out.println("Dice got: "+randomNum);
		return randomNum;
	}

}
