package model.exceptions;

/**
 * InvalidEmailException is an Exception class which is thrown when given email is not valid
 */
public class InvalidGmailException extends Exception {
    /**
     * No argument constructor with default message
     */
    public InvalidGmailException() {
        super("Email address is invalid.");
    }

    /**
     * Constructor that initializes exception with the give message
     *
     * @param msg String message
     */
    public InvalidGmailException(String msg) {
        super(msg);
    }
}
