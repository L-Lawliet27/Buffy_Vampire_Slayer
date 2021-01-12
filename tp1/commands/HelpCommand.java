package tp1.commands;

import tp1.exceptions.CommandParseException;
import tp1.logic.Game;

public class HelpCommand extends NoParamsCommand {

    private static final String name = "help";
    private static final String shortCut = "h";
    private static final String details = "[h]elp";
    private static final String help = "shows this help";

    public HelpCommand() {
        super(name,shortCut,details,help);
    }


    @Override
    public boolean execute(Game game) {
        System.out.println(CommandGenerator.commandHelp());
        return false;
    }

}
