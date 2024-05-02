package model.exceptions;

public class InvalidPatientException extends Exception {

    public InvalidPatientException() {
        super("This patient already exists");
    }

    public InvalidPatientException(String message) {
        super(message);
    }
}
