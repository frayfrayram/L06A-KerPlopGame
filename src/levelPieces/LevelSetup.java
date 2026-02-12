//Authors -- Franklin Rambo, Nicolas Finnochio
//Main levelSetup class, handles creating a board and inserting our game pieces (each their own class)


package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

//Creates game pieces as public objects within levelSetuo(might be a better way to do this but this seems to work)
public class LevelSetup {
	public int levelNum;
	public Drawable[] gameBoard = new Drawable[10];
	public GamePiece nonMovingPrize1 = new nonMovePrize('X', 2, "Non moving prize");
	public GamePiece nonMovingPrize2 = new nonMovePrize('X', 7, "Non moving prize");

	
	
	//Just createsLevel
	public void createLevel(int num) {
		levelNum = num;


	}
	
	//Adds our objects to game board and returns complete board
	public Drawable[] getBoard() {
		gameBoard[nonMovingPrize1.getLocation()] = nonMovingPrize1;
		gameBoard[nonMovingPrize2.getLocation()] = nonMovingPrize2;
		return gameBoard;
	}



	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> MovePieces = new ArrayList<Moveable>();
		return MovePieces;
	}



	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> Pieces = new ArrayList<GamePiece>();
		Pieces.add(nonMovingPrize1);
		Pieces.add(nonMovingPrize2);
		return Pieces;
	}



	public int getPlayerStartLoc() {
		return 4;
	}
}
