//Authors -- Franklin Rambo, Nicolas Finnochio
//Main levelSetup class, handles creating a board and inserting our game pieces (each their own class)


package levelPieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

//Creates game pieces as public objects within levelSetuo(might be a better way to do this but this seems to work)
public class LevelSetup {
    public int levelNum;
    public Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    public GamePiece Dude = new Dude('D', "just a chill dude", 14);
    public Drawable Ghost = new Ghost('G');
    public GamePiece Goomba = new Goomba('g', "goomba (little guy from mario)", 8);
    public GamePiece Hole = new Hole('H', "very deep hole", 13);
    public GamePiece MovePrize = new MovePrize('X', "moving box of goodies", 9);
    public GamePiece nonMovePrize1 = new NonMovePrize('x', "non moving prize", 2);
    public GamePiece nonMovePrize2 = new NonMovePrize('x', "non moving prize", 7);
    public GamePiece Turret = new Turret('T', "dangerous turret!", (GameEngine.BOARD_SIZE - 1));

    


    //Just createsLevel
    public void createLevel(int num) {
        levelNum = num;
    }

    //Adds our objects to game board and returns complete board
    public Drawable[] getBoard() {
    	if(levelNum == 1) {
    		gameBoard[Dude.getLocation()] = Dude;
    		gameBoard[11] = Ghost;
    		gameBoard[Hole.getLocation()] = Hole;
    		gameBoard[nonMovePrize1.getLocation()] = nonMovePrize1;
    		gameBoard[nonMovePrize2.getLocation()] = nonMovePrize2;
    		return gameBoard;
    	} else if(levelNum == 2) {
		gameBoard[Goomba.getLocation()] = Goomba;
		gameBoard[MovePrize.getLocation()] = MovePrize;
		gameBoard[Turret.getLocation()] = Turret;
		return gameBoard;
    	} else return null;
    }

    private <T> ArrayList<T> getTypes(Class<T> clazz) {
        return Arrays.stream(gameBoard)
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Moveable> getMovingPieces() {
        return getTypes(Moveable.class);
    }


    public ArrayList<GamePiece> getInteractingPieces() {
        return getTypes(GamePiece.class);
    }


    public int getPlayerStartLoc() {
        return 4;
    }
}
