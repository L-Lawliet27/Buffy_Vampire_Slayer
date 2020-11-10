package tp1.commands;

import tp1.logic.Game;

public class ResetCommand{

    private String commandName;
    private String commandShortCut;

    public ResetCommand() {
       // super("reset", "r");
        commandName = "reset";
        commandShortCut = "r";
    }

    //@Override
    public boolean execute(Game game) {
        game.reset();
        return false;
    }
}
