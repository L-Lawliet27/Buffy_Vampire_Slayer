package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.logic.Game;

public class StringifyCommand extends NoParamsCommand {

    private static final String name = "stringify";
    private static final String shortCut = "t";
    private static final String details = "s[t]ringify";
    private static final String help = "prints the current state of the game";

    public StringifyCommand() {
        super(name,shortCut,details,help);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        System.out.println(game.stringify());
        return false;
    }
}
