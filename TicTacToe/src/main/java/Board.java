package main.java;

import java.util.ArrayList;
import java.util.List;
import main.java.PlayingPiece.PieceType;

public class Board {

	int size;
	PlayingPiece[][] board;
	Board(int n){
		this.size = n;
		this.board = new PlayingPiece[n][n];
	}
	
	boolean addPiece(int x, int y, PlayingPiece pt) {
		if(board[x][y]==null) {
			board[x][y] = pt;
			return true;
		}
		return false;
	}
	
	List<Pair<Integer,Integer>> getFreeCells(){
		List<Pair<Integer,Integer>> freeCells = new ArrayList();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null) {
					Pair<Integer,Integer> p = new Pair<>(i,j);
					freeCells.add(p);
				}
			}
		}
		return freeCells;
	}
	
	public void printBoard(){
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j] == null)
					System.out.print("   |");
				else
					System.out.print(board[i][j].pieceType+"  |");
			}
			System.out.println();
		}
	}
	
	public boolean isFull(){
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]==null)
					return false;
			}
		}
		return true;
	}
	
}
