package tp1.game;

import java.util.Scanner;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameException;
import tp1.logic.Game;
import tp1.printer.GamePrinter;
import tp1.commands.*;

public class Controller {
	
	public final String prompt = "Command > ";

	/*
	public static final String unknownCommandMsg = String.format("Unknown command\n");
	public static final String invalidCommandMsg = String.format("Invalid command\n");
	public static final String invalidPositionMsg = String.format("Invalid position\n");
*/
    private Game game;
    private GamePrinter printer;
    private Scanner scanner;
    private boolean refreshDisplay;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	    refreshDisplay = true;
	    printer = new GamePrinter(this.game, this.game.getDimX(), this.game.getDimY());
    }
    
    public void printGame() {
    	System.out.println(printer);
   }
    
    public void run() {
		while (!game.isOver()){
			if (refreshDisplay) printGame();
			refreshDisplay = false;
			System.out.println(prompt);
			String s = scanner.nextLine();
			String[] commandWords = s.toLowerCase().trim().split("\\s+");
			System.out.println("[DEBUG] Executing: " + s);
			try {
                Command command = CommandGenerator.parseCommand(commandWords);
				refreshDisplay = command.execute(game);
            } catch (GameException ex){
				System.out.println("[ERROR]: " + ex.getMessage());
			}
		}//game loop

		printGame();
		System.out.println("[GAME OVER] " + game.winnerMessage());
    }

}

