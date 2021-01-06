package tp1.exceptions;

public class DraculaHasRisenException extends NoMoreVampiresException {

    public DraculaHasRisenException(){
        super("Dracula is Already On Board\n");
    }

    public DraculaHasRisenException(String message){
        super(message);
    }
}
