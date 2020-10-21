package tp1.commands;

import tp1.logic.Game;

public class ResetCommand extends Command {

    public ResetCommand() {
        super("reset", "r");
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
