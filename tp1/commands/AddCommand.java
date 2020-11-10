package tp1.commands;

import tp1.logic.Game;

public class AddCommand{

    private String commandName;
    private String commandShortCut;

    public AddCommand() {
        //super("add", "a");
        commandName = "add";
        commandShortCut = "a";
    }

    //@Override
    public boolean execute(Game game, int x, int y) {
        return game.addSlayer(x,y);
    }

}
