package tp1.commands;

import tp1.logic.Game;

public class UpdateCommand extends NoParamsCommand {

  //  private String additionalSC1 = "\n";
    private String additionalSC1 = "";

    private static final String name = "none";
    private static final String shortCut = "n";
    private static final String details = "[n]one | []";
    private static final String help = "updates the game";

    public UpdateCommand() {
        super(name,shortCut,details,help);
    }

    @Override
    public boolean execute(Game game) {
        game.update();
        return true;
    }

    @Override
    protected boolean matchCommandName(String n) {
        return shortCut.equalsIgnoreCase(n) || name.equalsIgnoreCase(n)
                 || additionalSC1.equals(n);
    }
}
