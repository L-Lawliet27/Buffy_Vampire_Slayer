package tp1.commands;

import tp1.logic.Game;

public class ResetCommand extends Command{


    public ResetCommand() {
        super("reset", "r", "[e]xit", "exit game%n");
    }

    @Override
    public boolean execute(Game game) {
        game.reset();
        return true;
    }

}
