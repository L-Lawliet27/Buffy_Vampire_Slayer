package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.NotEnoughCoinsException;
import tp1.logic.Game;

public class AddBloodBankCommand extends Command{

    private int x, y, cost;
    private static final String name = "bank";
    private static final String shortCut = "b";
    private static final String details = "[b]ank <x> <y> <z>";
    private static final String help = "add a blood bank in position x, y which " +
            "returns 10% of the amount spent on it on each turn";
    private static final String wrongArgMessage = "(BloodBank Command) " + incorrectNumberOfArgsMsg + " - [b]ank <x> <y> <z>";
    private static final String wrongFormMessage = "(BloodBank Command) " + incorrectArgsMsg + " - Coordinates and Cost should be numbers";
    private static final String failedMessage = "Failed to add BloodBank";
    public AddBloodBankCommand() {
        super(name, shortCut, details, help);
    }

    public AddBloodBankCommand(int x, int y, int cost){
        this();
        this.x=x;
        this.y=y;
        this.cost=cost;
    }


    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            return game.addBloodBank(x, y, cost);
        }catch (NotEnoughCoinsException c){
            System.out.println("[DEBUG]: " + c.getMessage());
            throw new CommandExecuteException(failedMessage);
        }
    }


    @Override
    public Command parse(String[] commandWords) throws CommandParseException {

        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 4) {
                try {
                    x = Integer.parseInt(commandWords[2]);
                    y = Integer.parseInt(commandWords[1]);
                    cost = Integer.parseInt(commandWords[3]);
                    return new AddBloodBankCommand(x, y, cost);
                }catch (NumberFormatException nfe){
                    throw new CommandParseException(wrongFormMessage);
                }
            }else throw new CommandParseException(wrongArgMessage);
        }

        return null;
    }


}
