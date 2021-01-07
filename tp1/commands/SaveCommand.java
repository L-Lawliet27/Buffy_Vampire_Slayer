package tp1.commands;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveCommand extends Command {

    private String nameOfFile;
    private BufferedWriter bufferedWriter;

    public SaveCommand() {
        super("save", "s", "[s]ave", "saves the current state of the game");
    }

    public SaveCommand(String nameOfFile){
        this();
        this.nameOfFile = nameOfFile + ".dat\n";
    }

    @Override
    public boolean execute(Game game) throws CommandExecuteException {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nameOfFile));
            bufferedWriter.write(game.stringify());
            bufferedWriter.close();
        } catch (IOException io){
            throw new CommandExecuteException("Cannot Save the Game\n");
        }

        System.out.println("Game Successfully Saved in File " + nameOfFile);
        return false;
    }

    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        if(matchCommandName(commandWords[0])){
            if(commandWords.length == 2) {
                return new SaveCommand(commandWords[1]);
            }else throw new CommandParseException(incorrectNumberOfArgsMsg);
        }
        return null;
    }



}
