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
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
	    printer = new GamePrinter(this.game, this.game.getDimX(), this.game.getDimY());
    }
    
    public void printGame() {
    	System.out.println(printer);
   	 	//System.out.println(printer.toString());
   	 	//System.out.println(game);
   }
    
    public void run() {
		while(!game.isOver()){
			printGame();
			System.out.println(prompt);
			String[] playerInput = scanner.nextLine().toLowerCase().trim().split("\\s+");

			if(playerInput.length == 3 && playerInput[0].equals("add") || playerInput[0].equals("a")){
				int posY = Integer.parseInt(playerInput[1]);
				int posX = Integer.parseInt(playerInput[2]);
				if(!new AddCommand().execute(game, posX, posY)){
					if(Game.getEnoughCoins()){
						game.setNotEnoughCoins();
						System.out.println("Not Enough Coins\n");

					} else System.out.println(invalidPositionMsg);
				}
			}

			else if (playerInput.length == 1){

				switch (playerInput[0]){
					case "help":
					case "h": System.out.println(helpMsg);;
						break;
					case "reset":
					case "r": new ResetCommand().execute(game);
						break;
					case "exit":
					case "e": new ExitCommand().execute(game);
						break;
					case "\n":
					case "none":
					case "n":
					case "": new NoneCommand().execute(game);
						break;
					default: System.out.println(unknownCommandMsg);
				}

			} else System.out.println(invalidCommandMsg);

		}//game loop
		printGame();
		game.winnerMessage();
		System.out.println("Game Over");
    }

}

