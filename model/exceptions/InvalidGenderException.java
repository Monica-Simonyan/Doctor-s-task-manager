package model.exceptions;

public class InvalidGenderException extends Exception {
    public InvalidGenderException() {
        super("Please select a gender");
    }

    public InvalidGenderException(String msg) {
        super(msg);
    }
}
