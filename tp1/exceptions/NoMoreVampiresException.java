package tp1.exceptions;

public class NoMoreVampiresException extends CommandExecuteException {

    public NoMoreVampiresException(){
        super("No More Vampires Available\n");
    }

    public NoMoreVampiresException(String message){
        super(message);
    }
}
