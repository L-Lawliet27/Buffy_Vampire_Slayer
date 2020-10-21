package tp1.commands;

import tp1.logic.Game;

public abstract class Command {

    private String commandName;
    private String commandShortCut;

    public Command(String name, String shortCut){
        commandName = name;
        commandShortCut = shortCut;
    }

    public abstract boolean execute(Game game);

    public String getCommandName() {
        return commandName;
    }

    public String getCommandShortCut() {
        return commandShortCut;
    }


}
