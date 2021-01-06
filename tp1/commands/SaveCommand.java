package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.logic.Game;

public class SaveCommand extends Command {

    public SaveCommand() {
        super("save", "s", "[s]ave", "saves the current state of the game");
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        return false;
    }
}
