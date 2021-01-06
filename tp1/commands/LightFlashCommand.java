package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class LightFlashCommand extends Command{

    public LightFlashCommand() {
        super("light", "l", "[l]ight", "eliminates all vampires, except Dracula");
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.lightAttack();
        }catch (NotEnoughCoinsException e){
            System.out.println("[ERROR]: " + e.getMessage());
            throw new CommandExecuteException("Failed to Release LightFlash\n");
        }
    }
}
