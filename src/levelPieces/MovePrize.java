package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MovePrize extends GamePiece implements Moveable {
    /**
     * Constructor for the game piece
     *
     * @param symbol   symbol for the game piece
     * @param label    TODO
     * @param location initial location
     */
    public MovePrize(char symbol, String label, int location) {
        super(symbol, label, location);
		System.out.println(symbol + " is a " + label);
    }

    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
        int location = getLocation();
        int moveDir = location - playerLocation;
        // Run away from the closest piece
        for (Drawable drawable : gameBoard)
            if (drawable != this && drawable instanceof GamePiece gamePiece)
                if (Math.abs(location - gamePiece.getLocation()) < Math.abs(moveDir))
                    moveDir = Math.min(moveDir, location - gamePiece.getLocation());

        // Normalize
        moveDir /= Math.abs(moveDir);
        setLocation(getLocation() + moveDir);
        gameBoard[location] = null;
        gameBoard[getLocation()] = this;
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (getLocation() == playerLocation) {
        	System.out.println("You found a BIG prize!");
            return InteractionResult.ADVANCE;
        }
        return InteractionResult.NONE;
    }
}
