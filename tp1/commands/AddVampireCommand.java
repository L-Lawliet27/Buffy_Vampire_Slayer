package tp1.commands;

import tp1.logic.Game;

public class AddVampireCommand extends Command {

    private int x, y;
    private String type;
    private final String dracula = "D";
    private final String explosive = "E";


    public AddVampireCommand(){
        super("vampire", "v", "[v]ampire [<type>] <x> <y>", "add a vampire in position x, y%n");

    }


    public AddVampireCommand(String type, int x, int y) {
        this();
        this.type=type;
        this.x = x;
        this.y=y;
    }

    @Override
    public boolean execute(Game game) {

        switch (type) {
            case dracula:
                return game.addDracula(x,y);
            case explosive:
                return game.addExplosiveVampire(x,y);
            case " ":
            case "":
                return game.addVampire(x,y);
        }

        return false;
    }

    @Override
    public Command parse(String[] commandWords){
        if(matchCommandName(commandWords[0]) && commandWords.length == 4){
            if(matchTypeName(commandWords[1])) {
                type = commandWords[1].toUpperCase();
                x = Integer.parseInt(commandWords[2]);
                y = Integer.parseInt(commandWords[3]);
                return new AddVampireCommand(type, x, y);
            }
        } else if (matchCommandName(commandWords[0]) && commandWords.length == 3){
            x = Integer.parseInt(commandWords[1]);
            y = Integer.parseInt(commandWords[2]);
            return new AddVampireCommand("", x, y);
        }
        return null;
    }


    private boolean matchTypeName(String type){
        return type.toUpperCase().equals(dracula) || type.toUpperCase().equals(explosive) || type.equals(" ");
    }



}
