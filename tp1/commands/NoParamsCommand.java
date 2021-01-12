package tp1.commands;

import tp1.exceptions.CommandParseException;

public abstract class NoParamsCommand extends Command {

    public NoParamsCommand(String name, String shortcut, String details, String help) {
        super(name, shortcut, details, help);
    }

    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])){
            return this;
        }
        return null;
    }
}
