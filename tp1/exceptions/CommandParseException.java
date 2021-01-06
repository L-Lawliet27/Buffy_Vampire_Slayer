package tp1.exceptions;

public class CommandParseException extends GameException {

    public CommandParseException(){
        super("Unknown Command\n");
    }

    public CommandParseException(String message){
        super(message);
    }



}
