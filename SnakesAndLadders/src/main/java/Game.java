package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {

	Deque<Player> players;
	Board board;
	Dice dice;
	public Game() {
		initialiseGame();
	}
	
	void initialiseGame(){
		board = new Board(6, 2, 3);
		dice = new Dice(1);
		addPlayers();	
	}
	
	String playGame(){
		boolean noWinner = true;
		while(noWinner) {
			Player curr = players.removeFirst();
			System.out.println("Player "+curr.name+" is at "+curr.currPos);
			int roll = dice.rollDice();
			/*
			 * if(curr.currPos==0 && roll!=6) { players.addLast(curr); continue; }
			 */
			
			int nextPos = curr.currPos+roll;
			if((nextPos)>board.lastCellPos()) {
				System.out.println("Can't move to "+nextPos+" as last position is: "+board.lastCellPos());
				players.addLast(curr);
				continue;
			}
			if(board.lastCellPos()==nextPos) {
				return curr.getName();
			}
			Cell c = board.getCell(nextPos);
			if(c.snakeLadder!=null) {
				System.out.println("Player "+curr.name+" moved from "+c.snakeLadder.start+" to "+c.snakeLadder.end);
				nextPos = c.snakeLadder.end;	
			}
			curr.currPos = nextPos;
			players.addLast(curr);
		}
		return "tie";
	}
	
	void addPlayers(){
		Player p1 = new Player("Kritika");
		Player p2 = new Player("Anand");
		players = new ArrayDeque<>();
		players.add(p1);
		players.add(p2);
	}

}
