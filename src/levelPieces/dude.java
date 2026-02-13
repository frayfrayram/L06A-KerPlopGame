//Author - Franklin Rambo

package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Dude extends GamePiece implements Moveable{
	
	public Dude(char symbol, String label, int location) {
		super(symbol, label, location);
	}


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int oldLocation = getLocation();
		if(getLocation() == (GameEngine.BOARD_SIZE - 1)) {
			setLocation(0);
		}
		setLocation(getLocation() + 1);
		gameBoard[oldLocation] = null;
		gameBoard[getLocation()] = this;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}
}	
