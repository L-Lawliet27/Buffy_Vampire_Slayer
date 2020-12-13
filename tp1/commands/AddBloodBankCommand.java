package tp1.commands;

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
    public boolean execute(Game game) {
        return game.addBloodBank(x, y, cost);
    }



    @Override
    public Command parse(String[] commandWords){

        if(matchCommandName(commandWords[0]) &&  commandWords.length == 4){
            x = Integer.parseInt(commandWords[1]);
            y = Integer.parseInt(commandWords[2]);
            cost = Integer.parseInt(commandWords[3]);
            return new AddBloodBankCommand(x, y, cost);
        }

        return null;
    }


}
