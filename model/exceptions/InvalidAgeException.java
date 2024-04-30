package model.exceptions;

/**
 * Class InvalidAgeException is an exception which is thrown when input age is not valid
 */
public class InvalidAgeException extends Exception {
    /**
     * No argument constructor with default message
     */
    public InvalidAgeException() {
        super("Please enter a valid age.");
    }

    /**
     * Constructor that initializes exception with the given message
     *
     * @param msg message of type String
     */
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
