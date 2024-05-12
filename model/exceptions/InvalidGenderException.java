package model.exceptions;
/**
 * The InvalidGenderException class represents an exception that is thrown
 * when an invalid gender is encountered. This typically occurs when attempting
 * to process or validate gender-related data.
 */
public class InvalidGenderException extends Exception {
    /**
     * Constructs a new InvalidGenderException with a default error message.
     * The default message advises to select a gender.
     */
    public InvalidGenderException() {
        super("Please select a gender");
    }
    /**
     * Constructs a new InvalidGenderException with a custom error message.
     * This constructor allows specifying a more specific error message.
     *
     * @param msg the custom error message describing the reason for the exception
     */
    public InvalidGenderException(String msg) {
        super(msg);
    }
}
