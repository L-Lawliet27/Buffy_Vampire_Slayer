package tp1.commands;

import tp1.logic.Game;

public class GarlicPushCommand extends Command {

    public GarlicPushCommand() {
        super("garlic", "g", "[g]arlic", "pushes vampires back one tile");
    }

    @Override
    public boolean execute(Game game) {
        return game.garlicAttack();
    }
}
