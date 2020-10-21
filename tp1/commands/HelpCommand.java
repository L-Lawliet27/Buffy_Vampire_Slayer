package tp1.commands;

import tp1.logic.Game;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "h");
    }

    @Override
    public boolean execute(Game game) {
        return false;
    }
}
