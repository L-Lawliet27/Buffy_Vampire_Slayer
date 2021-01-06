package tp1.exceptions;

public class CommandExecuteException extends GameException{

    public CommandExecuteException(){
        super("Failed to Execute\n");
    }

    public CommandExecuteException(String message){
        super(message);
    }
}
