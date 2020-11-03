package tp1.commands;

import tp1.logic.Game;

public class NoneCommand extends Command{

    public NoneCommand() {
        super("none", "n");

    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}