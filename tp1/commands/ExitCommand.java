package tp1.commands;

import tp1.logic.Game;

public class ExitCommand extends Command{

    public ExitCommand() {
        super("exit", "e", "[e]xit", "exit game");
    }

    @Override
    public boolean execute(Game game) {
        game.exit();
        return false;
    }


}
