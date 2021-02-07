package tp1.exceptions;

public class NotEnoughCoinsException extends GameException {

    public NotEnoughCoinsException(){
        super("Not Enough Coins");
    }

    public NotEnoughCoinsException(String message){
        super(message);
    }
}
