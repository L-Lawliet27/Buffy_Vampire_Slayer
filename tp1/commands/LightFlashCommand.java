package tp1.commands;

import tp1.logic.Game;

public class LightFlashCommand extends Command{

    public LightFlashCommand() {
        super("light", "l", "[l]ight", "eliminates all vampires, except Dracula");
    }

    @Override
    public boolean execute(Game game) {
        return game.lightAttack();
    }
}
