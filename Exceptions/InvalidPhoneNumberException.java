package Exceptions;

public class InvalidPhoneNumberException extends Exception{
    /**
     * No argument constructor with default message
     */
    public InvalidPhoneNumberException(){
        super("Phone number is not valid.");
    }
    public InvalidPhoneNumberException(String msg){
        super(msg);
    }
}
