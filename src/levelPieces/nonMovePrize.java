//Author -- Franklin Rambo
//Non moving prize -- simply a non moving object that gives a point when reached

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class NonMovePrize extends GamePiece {
	public int loc;
	public char sym;
	public boolean stillAvailable = true;
	
	public NonMovePrize(char symbol, String label, int location){
		super(symbol, label, location);
		System.out.println(symbol + " is a " + label);
		loc = location;
		sym = symbol;
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(stillAvailable && (playerLocation == loc)) {
			sym = ' ';
			stillAvailable = false;
			return InteractionResult.GET_POINT;
		} else return null;
	}
	
	@Override 
	public void draw() {
		System.out.print(sym);
	}
}
