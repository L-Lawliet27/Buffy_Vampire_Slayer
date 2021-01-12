package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.Game;

public class AddVampireCommand extends Command {

    private int x, y;
    private String type;
    private static final String dracula = "D";
    private static final String explosive = "E";
    private static final String normal = "";
    private static final String name = "vampire";
    private static final String shortCut = "v";
    private static final String details = "[v]ampire [<type>] <x> <y>";
    private static final String help = "add a vampire in position x, y";


    public AddVampireCommand(){
        super(name, shortCut, details, help);

    }


    public AddVampireCommand(String type, int x, int y) {
        this();
        this.type=type;
        this.x = x;
        this.y=y;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {

        switch (type) {
            case dracula:
                return game.addDracula(x,y);
            case explosive:
                return game.addExplosiveVampire(x,y);
            case normal:
                return game.addVampire(x,y);
            default: throw new CommandExecuteException("Cannot Execute [v]ampire Command");
        }

        //return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])) {
            if (commandWords.length == 4) {
                if (matchTypeName(commandWords[1])) {
                    type = commandWords[1].toUpperCase();
                    try {
                        x = Integer.parseInt(commandWords[3]);
                        y = Integer.parseInt(commandWords[2]);
                        return new AddVampireCommand(type, x, y);
                    } catch (NumberFormatException nfe){
                        throw new CommandParseException("(Vampire Command) " + incorrectArgsMsg + " - Coordinates should be numbers");
                    }
                } else throw new CommandParseException("Invalid Type: [v]ampire [<type>] <x> <y>" +
                        " -- type = {\"\"|\"D\"|\"E\"}");

            } else if (commandWords.length == 3) {
                try {
                    x = Integer.parseInt(commandWords[2]);
                    y = Integer.parseInt(commandWords[1]);
                    return new AddVampireCommand("", x, y);
                }catch (NumberFormatException nfe){
                    throw new CommandParseException("(Vampire Command) " + incorrectArgsMsg + " - Coordinates should be numbers");
                }
            } else throw new CommandParseException(incorrectNumberOfArgsMsg + " - [v]ampire [<type>] <x> <y>");
        }
        return null;
    }


    private boolean matchTypeName(String type){
        return type.toUpperCase().equals(dracula) || type.toUpperCase().equals(explosive) || type.equals(normal);
    }



}
