package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SaveCommand extends Command {

    private String nameOfFile;

    private static final String name = "save";
    private static final String shortCut = "s";
    private static final String details = "[s]ave [<filename>]";
    private static final String help = "saves the current state of the game";
    private static final String failedMessage = String.format("Cannot Save the Game%n");
    private static final String wrongArgMessage = incorrectNumberOfArgsMsg + " - [s]ave [<filename>]";

    public SaveCommand() {
        super(name,shortCut,details,help);
    }

    public SaveCommand(String nameOfFile){
        this();
        this.nameOfFile = String.format(nameOfFile + ".dat%n");
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameOfFile));
            bufferedWriter.write(game.stringify());
            bufferedWriter.close();
        } catch (IOException io){
            throw new CommandExecuteException(failedMessage);
        } finally {
            System.out.println("Game Successfully Saved in File " + nameOfFile);
        }
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 2) {
                return new SaveCommand(commandWords[1]);
            }else throw new CommandParseException(wrongArgMessage);
        }
        return null;
    }



}
