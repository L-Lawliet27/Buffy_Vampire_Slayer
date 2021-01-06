package tp1.exceptions;

public class CommandParseException extends GameException {

    public CommandParseException(){
        super("Invalid command\n");
    }

    public CommandParseException(String message){
        super(message);
    }



}
