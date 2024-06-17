package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import main.java.PlayingPiece.PieceType;

public class Game {
	Deque<Player> queue;
	 Board gameboard;
	Game(List<Player> players, Board bd){
		this.gameboard = bd;
		queue = new ArrayDeque<>();
		queue.addAll(players);
	}
	 
	String playGame(){
		boolean winner = false;
		
		while(!winner) {
			Player p = queue.removeFirst();
			gameboard.printBoard();
			if(gameboard.isFull()) {
				return "tie";
			}
			
			System.out.println("Add row,col for Player: "+p.name);
			Scanner scn = new Scanner(System.in);
			String inp = scn.nextLine();
			String values[] = inp.split(",");
			int x = Integer.parseInt(values[0]);
			int y = Integer.parseInt(values[1]);
			boolean addPieceSuccess = gameboard.addPiece(x,y,p.playingPiece);
			if(!addPieceSuccess){
				System.out.println("Can't add at already occupied space"); // syso + Ctrl + spacebar
				queue.addFirst(p);
				continue;
			}
			winner = checkWinner(x,y, p.getPlayingPiece().pieceType);
			if(winner) {
				return p.name;
			}
			queue.addLast(p);
		}
		return "tie";
	}
	boolean checkWinner(int row, int col, PieceType piece){
		boolean rowMatch = true, colMatch = true, diagonalMatch = true, antiDiagonalMatch = true;
		for(int i=0;i<gameboard.size;i++) {
			if(gameboard.board[row][i]==null || gameboard.board[row][i].pieceType !=piece)
				colMatch = false;
		}
		
		for(int i=0;i<gameboard.size;i++) {
			if(gameboard.board[i][col]==null || gameboard.board[i][col].pieceType!=piece) {
				rowMatch=false;
			}
		}
		for(int i=0, j=0;i<gameboard.size;i++, j++) {
			if(gameboard.board[i][j]==null || gameboard.board[i][j].pieceType!=piece) {
				diagonalMatch=false;
			}
		}
		for(int i=0, j=gameboard.size-1;i<gameboard.size;i++, j--) {
			if(gameboard.board[i][j]==null || gameboard.board[i][j].pieceType!=piece) {
				antiDiagonalMatch=false;
			}
		}
		return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
	}
	

}
