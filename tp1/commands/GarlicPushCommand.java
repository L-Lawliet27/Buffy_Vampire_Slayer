package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class GarlicPushCommand extends NoParamsCommand {

    private static final String name = "garlic";
    private static final String shortCut = "g";
    private static final String details = "[g]arlic";
    private static final String help = "pushes vampires back one tile";

    public GarlicPushCommand() {
        super(name, shortCut, details, help);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.garlicAttack();
        }catch (NotEnoughCoinsException e){
            System.out.println("[ERROR]: " + e.getMessage());
            throw new CommandExecuteException("Failed to Release Garlic Push");
        }
    }
}
