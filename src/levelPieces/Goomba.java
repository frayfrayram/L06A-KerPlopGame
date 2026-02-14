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
		System.out.println(symbol + " is a " + label);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

		if (Math.abs(getLocation() - playerLocation) < 2) {
			System.out.println("The goomba hit you!");
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int moveDir = playerLocation - getLocation();
		int oldLocation = getLocation();
		// Normalize
		if(moveDir != 0) {
			moveDir /= Math.abs(moveDir);
		}
		setLocation(getLocation() + moveDir);
		gameBoard[oldLocation] = null;
		gameBoard[getLocation()] = this;
	}
}
