package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.logic.Game;

public class StringifyCommand extends Command {

    public StringifyCommand() {
        super("stringify", "t", "s[t]ringify", "prints the current state of the game");
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        System.out.println(game.stringify());
        return false;
    }
}
