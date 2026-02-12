//Authors -- Franklin Rambo, Nicolas Finnochio
//Main levelSetup class, handles creating a board and inserting our game pieces (each their own class)


package levelPieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import gameEngine.Drawable;
import gameEngine.Moveable;

//Creates game pieces as public objects within levelSetuo(might be a better way to do this but this seems to work)
public class LevelSetup {
    public int levelNum;
    public Drawable[] gameBoard = new Drawable[10];
    public GamePiece nonMovingPrize1 = new NonMovePrize('X', 2, "Non moving prize");
    public GamePiece nonMovingPrize2 = new NonMovePrize('X', 7, "Non moving prize");


    //Just createsLevel
    public void createLevel(int num) {
        levelNum = num;


    }

    //Adds our objects to game board and returns complete board
    public Drawable[] getBoard() {
        gameBoard[nonMovingPrize1.getLocation()] = new Goomba('G',"Goomba",2);
        gameBoard[nonMovingPrize2.getLocation()] = nonMovingPrize2;
        return gameBoard;
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
