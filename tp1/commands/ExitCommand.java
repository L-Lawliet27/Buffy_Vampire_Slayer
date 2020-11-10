package tp1.commands;

import tp1.logic.Game;

public class ExitCommand{

    private String commandName;
    private String commandShortCut;

    public ExitCommand() {
        //super("exit", "e");
        commandName = "exit";
        commandShortCut = "e";
    }

    //@Override
    public boolean execute(Game game) {
        game.exit();
        return false;
    }
}
