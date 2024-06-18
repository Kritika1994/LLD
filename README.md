# LLD
LowLevelDesign

1. TicTacToeGame: Here we identify the main classes/components involved which is players, a board, and playingpieces. The playing pieces will be of 2 types X,O. We will create them as an enum named PlayingPieceType. We create 2 classes with the name PlayingPieceX, PlayingPieceO which has 'is-a' relationship with the class PlayingPiece. The board  object contains 'has-a' relationship with the PlayingPiece and it has a size. We also have Players in the system who will actually play the game. Now there's a class which runs the whole thing and it goes by the name 'Game'. Main classes just runs the game. 
2. LoggingHandler: This depicts the Chain Of Responsibility Principle where we don't need to create different objects for different things. Rather, we chain all of them using nextProcessor, and if the current class is not able to handle anything, it directly sends it to the next class in line. 
