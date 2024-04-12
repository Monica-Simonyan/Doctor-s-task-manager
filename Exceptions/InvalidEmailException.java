package Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(){
        super("Email address is invalid.");
    }
    public InvalidEmailException(String msg){
        super(msg);
    }
}
