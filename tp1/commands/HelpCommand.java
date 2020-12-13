package tp1.commands;

import tp1.logic.Game;

public class HelpCommand extends Command {


    public HelpCommand() {
        super("help", "h", "[h]elp", "show this help%n");
    }

    @Override
    public boolean execute(Game game) {
        System.out.println(CommandGenerator.commandHelp());
        return false;
    }

}
