package model.exceptions;
/**
 * The InvalidPatientException class represents an exception that is thrown
 * when attempting to perform an operation on a patient that already exists.
 * This exception is typically used in scenarios where duplicate patient records
 * are not allowed or when attempting to add a patient that is already present
 * in the system.
 */
public class InvalidPatientException extends Exception {
    /**
     * Constructs a new InvalidPatientException with a default error message.
     * The default message indicates that the patient already exists.
     */
    public InvalidPatientException() {
        super("This patient already exists");
    }
    /**
     * Constructs a new InvalidPatientException with a custom error message.
     * This constructor allows specifying a more specific error message.
     *
     * @param message the custom error message describing the reason for the exception
     */
    public InvalidPatientException(String message) {
        super(message);
    }
}
