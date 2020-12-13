package tp1.game;

import java.util.Scanner;
import tp1.logic.Game;
import tp1.printer.GamePrinter;
import tp1.commands.*;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command\n");
	public static final String invalidCommandMsg = String.format("Invalid command\n");
	public static final String invalidPositionMsg = String.format("Invalid position\n");

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
			Command command = CommandGenerator.parseCommand(commandWords);
			if (command != null)
				refreshDisplay = command.execute(game);
			else
				System.out.println("[ERROR]: "+ unknownCommandMsg);
		}//game loop

		printGame();
		game.winnerMessage();
		System.out.println("Game Over");
    }

}

