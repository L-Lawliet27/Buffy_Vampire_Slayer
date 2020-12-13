package tp1.commands;

import tp1.logic.Game;

public class UpdateCommand extends Command {

    private String additionalSC1 = "\n";
    private String additionalSC2 = "";

    public UpdateCommand() {
        super("none", "n", "[n]one | []", "updates the game");
    }

    @Override
    public boolean execute(Game game) {
        game.update();
        return true;
    }

    @Override
    protected boolean matchCommandName(String name) {
        return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name)
                || this.additionalSC1.equals(name) || this.additionalSC2.equals(name);
    }
}
