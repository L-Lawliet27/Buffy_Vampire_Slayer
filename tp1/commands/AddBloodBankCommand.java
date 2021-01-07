package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.Game;

public class AddBloodBankCommand extends Command{

    private int x, y, cost;

    public AddBloodBankCommand() {
        super("bank", "b", "[b]ank <x> <y> <z>", "add a blood bank in position x, y which " +
                "returns 10% of the amount spent on it on each turn");
    }

    public AddBloodBankCommand(int x, int y, int cost){
        this();
        this.x=x;
        this.y=y;
        this.cost=cost;
    }


    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        return game.addBloodBank(x, y, cost);
    }



    @Override
    public Command parse(String[] commandWords) throws CommandParseException {

        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 4) {
                x = Integer.parseInt(commandWords[2]);
                y = Integer.parseInt(commandWords[1]);
                cost = Integer.parseInt(commandWords[3]);
                return new AddBloodBankCommand(x, y, cost);
            }else throw new CommandParseException(incorrectNumberOfArgsMsg + " - [b]ank <x> <y> <z>");
        }

        return null;
    }


}
