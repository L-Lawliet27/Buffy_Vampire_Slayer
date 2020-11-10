package tp1.commands;

import tp1.logic.Game;

public class HelpCommand{

    private String commandName;
    private String commandShortCut;

    public HelpCommand() {
        //super("help", "h");
        commandName = "help";
        commandShortCut = "h";
    }

    //@Override
    public boolean execute(Game game) {
        return false;
    }
}
