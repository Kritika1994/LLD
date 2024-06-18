package main.java;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	int size;
	Cell[][] cells;
	public Board(int size, int snakes, int ladders) {
		this.size = size;
		cells = new Cell[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				cells[i][j] = new Cell(((i)*size)+j);
			}
		}
		addSnakesAndLadders(snakes,ladders);
	}
	int lastCellPos() {
		return (size*size)-1;
	}
	boolean isLastCell(int pos){
		int startX=pos/size;
		int startY=pos%size;
		if(startX==size-1 && startY==size-1)
			return true;
		return false;
	}
	void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(cells[i][j].digit+" ");
			}
			System.out.println();
		}
	}
	void addSnakesAndLadders(int snakes, int ladders) {
		int total = size*size;
		while(snakes>0) {
			int startCell = ThreadLocalRandom.current().nextInt(0, (size*size)+1);
			int endCell = ThreadLocalRandom.current().nextInt(0, (size*size)+1);
			
			if(endCell>startCell)
				continue;
			if(getCell(startCell).snakeLadder!=null)
				continue;
			PlayingPiece snake = new PlayingPiece(startCell, endCell);
			getCell(startCell).snakeLadder=snake;
			System.out.println("Snakes at: "+startCell+" "+endCell);
			snakes--;	
		}
		while(ladders>0) {
			int startCell = ThreadLocalRandom.current().nextInt(0, (size*size)+1);
			int endCell = ThreadLocalRandom.current().nextInt(0, (size*size)+1);
			
			if(startCell>endCell)
				continue;
			if(getCell(startCell).snakeLadder!=null)
				continue;
			
			PlayingPiece ladder = new PlayingPiece(startCell, endCell);
			getCell(startCell).snakeLadder=ladder;
			System.out.println("Ladders at: "+startCell+" "+endCell);
			ladders--;	
		}
		
	}
	
	Cell getCell(int pos){
		int startX=pos/size;
		int startY=pos%size;
		return cells[startX][startY];
	}

}
