package tp1.exceptions;

public class GameException extends Exception {

    public GameException(){
        super();
    }

    public GameException(String message){
        super(message);
    }
}