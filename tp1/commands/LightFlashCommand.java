package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class LightFlashCommand extends NoParamsCommand{

    private static final String name = "light";
    private static final String shortCut = "l";
    private static final String details = "[l]ight";
    private static final String help = "eliminates all vampires, except Dracula";
    private static final String failedMessage = "Failed to Release LightFlash";

    public LightFlashCommand() {
        super(name,shortCut,details,help);
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.lightAttack();
        }catch (NotEnoughCoinsException e){
            System.out.println("[DEBUG]: " + e.getMessage());
            throw new CommandExecuteException(failedMessage);
        }
    }
}
