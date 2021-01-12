package tp1.commands;

import tp1.logic.Game;

public class SuperCoinCommand extends NoParamsCommand{

    private static final String name = "coins";
    private static final String shortCut = "c";
    private static final String details = "[c]oins";
    private static final String help = "gives player 1000 coins";

    public SuperCoinCommand() {
        super(name,shortCut,details,help);
    }

    @Override
    public boolean execute(Game game) {
        game.superCoins();
        return true;
    }
}
