package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class AddSlayerCommand extends Command{

    private int x,y;
    private static final String name = "add";
    private static final String shortCut = "a";
    private static final String details = "[a]dd <x> <y>";
    private static final String help = "add a slayer in position x, y";
    private static final String failedMessage = "Failed to Add Slayer";
    private static final String wrongArgMessage = "(Add Command) " + incorrectNumberOfArgsMsg +" - [a]dd <x> <y>";
    private static final String wrongFormMessage = "(Add Command) " + incorrectArgsMsg + " - Coordinates should be numbers";

    public AddSlayerCommand() {
        super(name, shortCut, details, help);
    }

    public AddSlayerCommand(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.addSlayer(x, y);
        } catch (NotEnoughCoinsException e){
            System.out.println("[DEBUG]: " + e.getMessage());
            throw new CommandExecuteException(failedMessage);
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 3) {
                try {
                    x = Integer.parseInt(commandWords[2]);
                    y = Integer.parseInt(commandWords[1]);
                    return new AddSlayerCommand(x, y);
                }catch (NumberFormatException nfe){
                    throw new CommandParseException(wrongFormMessage);
                }
            } else throw new CommandParseException(wrongArgMessage);
        }
        return null;

    }


}
