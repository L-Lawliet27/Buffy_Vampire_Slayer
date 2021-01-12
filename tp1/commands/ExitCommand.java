package tp1.commands;

import tp1.logic.Game;

public class ExitCommand extends NoParamsCommand{

    private static final String name = "exit";
    private static final String shortCut = "e";
    private static final String details = "[e]xit";
    private static final String help = "exit game";

    public ExitCommand() {
        super(name, shortCut, details, help);
    }

    @Override
    public boolean execute(Game game) {
        game.exit();
        return false;
    }


}
