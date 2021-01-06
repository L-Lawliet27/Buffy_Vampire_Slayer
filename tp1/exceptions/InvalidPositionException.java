package tp1.exceptions;

public class InvalidPositionException extends CommandExecuteException {


    public InvalidPositionException(){
        super("Invalid Position");
    }

    public InvalidPositionException(String message){
        super(message);
    }

}
