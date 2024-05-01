package model.exceptions;
/**
 * InvalidPhoneNumberException is an Exception class which is thrown when given phone number is not valid
 */
public class InvalidPhoneNumberException extends Exception{
    /**
     * No argument constructor with default message
     */
    public InvalidPhoneNumberException(){
        super("Phone number is not valid.");
    }
    /**
     * Constructor that initializes exception with the give message
     *
     * @param msg String message
     */
    public InvalidPhoneNumberException(String msg){
        super(msg);
    }
}
