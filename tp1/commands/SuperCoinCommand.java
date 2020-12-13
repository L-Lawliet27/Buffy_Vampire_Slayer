package tp1.commands;

import tp1.logic.Game;

public class SuperCoinCommand extends Command{

    public SuperCoinCommand() {
        super("coins", "c", "[c]oins", "gives player 1000 coins");
    }

    @Override
    public boolean execute(Game game) {
        game.superCoins();
        return true;
    }
}
