package main.java;

class PlayingPiece{
	enum PieceType{
		X,
		O
	};
	public PieceType pieceType;
	PlayingPiece(PieceType pt){
		this.pieceType = pt;
	}
}