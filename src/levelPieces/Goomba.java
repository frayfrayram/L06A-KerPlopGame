package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Goomba extends GamePiece implements Moveable {
    /**
     * Constructor for the game piece
     *
     * @param symbol   symbol for the game piece
     * @param label    TODO
     * @param location initial location
     */
    public Goomba(char symbol, String label, int location) {
        super(symbol, label, location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

        if (Math.abs(getLocation() - playerLocation) <= 1) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int moveDir = playerLocation - getLocation();
        // Normalize
        moveDir /= Math.abs(moveDir);
        setLocation(getLocation() + moveDir);
    }
}
