package tp1.exceptions;

public class InvalidPositionException extends GameException {


    public InvalidPositionException(){
        super("Invalid Position");
    }

    public InvalidPositionException(String message){
        super(message);
    }

}
