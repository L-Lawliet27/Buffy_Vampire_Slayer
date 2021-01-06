package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class GarlicPushCommand extends Command {

    public GarlicPushCommand() {
        super("garlic", "g", "[g]arlic", "pushes vampires back one tile");
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.garlicAttack();
        }catch (NotEnoughCoinsException e){
            System.out.println("[ERROR]: " + e.getMessage());
            throw new CommandExecuteException("Failed to Release Garlic Push\n");
        }
    }
}
