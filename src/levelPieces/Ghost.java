package levelPieces;

import gameEngine.Drawable;

public class Ghost implements Drawable {
    private char _symbol;

    public Ghost(char symbol) {
    	System.out.println(symbol + " is a Ghost");
        _symbol = symbol;
    }

    @Override
    public void draw() {
        System.out.print(_symbol);
    }
}
