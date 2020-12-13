package tp1.commands;

import tp1.logic.Game;

public class HelpCommand extends Command {


    public HelpCommand() {
        super("help", "h", "[h]elp", "shows this help");
    }

    @Override
    public boolean execute(Game game) {
        System.out.println(CommandGenerator.commandHelp());
        return true;
    }

}
