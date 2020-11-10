package tp1.commands;

import tp1.logic.Game;

public class NoneCommand{

    private String commandName;
    private String commandShortCut;

    public NoneCommand() {
        //super("none", "n");
        commandName = "none";
        commandShortCut = "n";
    }

   // @Override
    public boolean execute(Game game) {
        game.update();
        return false;
    }
}
