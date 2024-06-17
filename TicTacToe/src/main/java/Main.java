package main.java;

import java.util.ArrayList;
import java.util.List;

import main.java.PlayingPiece.PieceType;

public class Main {

	public static void main(String args[]) {
		List<Player> players;
		players = new ArrayList<>();
		players.add(new Player("kriti",new PlayingPiece(PieceType.X)));
		players.add(new Player("anand",new PlayingPiece(PieceType.O)));
		Board board = new Board(3);
		Game game = new Game(players,board);
		
		System.out.println("Game winner is: "+game.playGame());
	}
}
