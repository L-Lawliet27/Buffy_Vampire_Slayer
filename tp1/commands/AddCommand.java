package tp1.commands;

import tp1.logic.Game;

public class AddCommand{

    private int positionX;
    private int positionY;

    public AddCommand(int x, int y) {
        //super("add", "a");
        positionX = x;
        positionY = y;
    }

    //@Override
    public boolean execute(Game game) {
        return false;
    }

    //TODO

}
