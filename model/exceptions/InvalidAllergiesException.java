package model.exceptions;

public class InvalidAllergiesException extends Exception{
    public InvalidAllergiesException(){
        super("Invalid Allergies");
    }

    public InvalidAllergiesException(String message){
        super(message);
    }
}
