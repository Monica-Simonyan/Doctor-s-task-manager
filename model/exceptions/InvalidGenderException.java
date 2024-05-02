package model.exceptions;

public class InvalidGenderException extends Exception{
    public InvalidGenderException(){
        super();
    }

    public InvalidGenderException(String msg){
        super(msg);
    }
}
