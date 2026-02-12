package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

import java.util.Random;

public class Turret extends GamePiece {
    /**
     * Constructor for the game piece
     *
     * @param symbol   symbol for the game piece
     * @param label    TODO
     * @param location initial location
     */
    public Turret(char symbol, String label, int location) {
        super(symbol, label, location);
    }

    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        if (rand.nextInt(10) > 7) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}
