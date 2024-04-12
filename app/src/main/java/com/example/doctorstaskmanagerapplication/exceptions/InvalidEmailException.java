package com.example.doctorstaskmanagerapplication.exceptions;

/**
 * InvalidEmailException is an Exception class which is thrown when given email is not valid
 */
public class InvalidEmailException extends Exception {
    /**
     * No argument constructor with default message
     */
    public InvalidEmailException() {
        super("Email address is invalid.");
    }

    /**
     * Constructor that initializes exception with the give message
     *
     * @param msg String message
     */
    public InvalidEmailException(String msg) {
        super(msg);
    }
}