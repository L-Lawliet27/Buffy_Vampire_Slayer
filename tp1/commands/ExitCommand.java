package tp1.commands;

import tp1.logic.Game;

public class ExitCommand extends Command{

    public ExitCommand() {
        super("exit", "e");
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}