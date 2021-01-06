package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class AddSlayerCommand extends Command{

    private int x,y;

    public AddSlayerCommand() {
        super("add", "a", "[a]dd <x> <y>", "add a slayer in position x, y");
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
            System.out.println("[ERROR]: " + e.getMessage());
            throw new CommandExecuteException("Failed to Add Slayer\n");
        }
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 3) {
                x = Integer.parseInt(commandWords[2]);
                y = Integer.parseInt(commandWords[1]);
                return new AddSlayerCommand(x, y);
            } else throw new CommandParseException("Invalid Argument Length - [a]dd <x> <y>");
        }
        return null;

    }


}
