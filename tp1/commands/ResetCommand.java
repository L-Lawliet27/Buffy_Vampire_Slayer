package tp1.commands;

import tp1.logic.Game;

public class ResetCommand extends Command{


    public ResetCommand() {
        super("reset", "r", "[r]eset", "resets the game");
    }

    @Override
    public boolean execute(Game game) {
        game.reset();
        return true;
    }

}
