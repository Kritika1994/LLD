package main.java;

public class Player {

	public String name;
	public PlayingPiece playingPiece;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlayingPiece getPlayingPiece() {
		return playingPiece;
	}
	public void setPlayingPiece(PlayingPiece playingPiece) {
		this.playingPiece = playingPiece;
	}
	Player(String name, PlayingPiece pt){
		this.name = name;
		this.playingPiece = pt;
	}
	
	
}
