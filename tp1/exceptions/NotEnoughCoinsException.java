package tp1.exceptions;

public class NotEnoughCoinsException extends CommandExecuteException {

    public NotEnoughCoinsException(){
        super("Not Enough Coins");
    }

    public NotEnoughCoinsException(String message){
        super(message);
    }
}
