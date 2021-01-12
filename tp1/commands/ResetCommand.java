package tp1.commands;

import tp1.logic.Game;

public class ResetCommand extends NoParamsCommand{

    private static final String name = "reset";
    private static final String shortCut = "r";
    private static final String details = "[r]eset";
    private static final String help = "resets the game";

    public ResetCommand() {
        super(name,shortCut,details,help);
    }

    @Override
    public boolean execute(Game game) {
        game.reset();
        return true;
    }

}
