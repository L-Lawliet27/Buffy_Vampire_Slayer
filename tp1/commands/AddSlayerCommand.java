package tp1.commands;

import tp1.logic.Game;

public class AddSlayerCommand extends Command{

    private int x,y;

    public AddSlayerCommand() {
        super("add", "a", "[a]dd <x> <y>", "add a slayer in position x, y%n");
    }

    public AddSlayerCommand(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Game game) {
       return game.addSlayer(x,y);
    }

    @Override
    public Command parse(String[] commandWords){
        if(matchCommandName(commandWords[0]) &&  commandWords.length == 3){
            x = Integer.parseInt(commandWords[1]);
            y = Integer.parseInt(commandWords[2]);
            return new AddSlayerCommand(x, y);
        }
        return null;
    }


}
