package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Hole extends GamePiece {
    /**
     * Constructor for the game piece
     *
     * @param symbol   symbol for the game piece
     * @param label    TODO
     * @param location initial location
     */
    public Hole(char symbol, String label, int location) {
        super(symbol, label, location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if(playerLocation == getLocation()){
            return InteractionResult.KILL;
        }
        return InteractionResult.NONE;
    }
}
