package com.example.doctorstaskmanagerapplication.gui;

/**
 * <code>CannotAddPatientException</code> constructs an exception if a patient
 * cannot be added to the list of patients
 */
public class CannotAddPatientException extends Exception{
    /**
     * constructs a new <code>CannotAddPatientException</code> exception
     * with null as its detail message
     */
    public CannotAddPatientException(){
        super();
    }

    /**
     * constructs a new <code>CannotAddPatientException</code> exception
     * with the specified detail message
     */
    public CannotAddPatientException(String message){
        super(message);
    }
}
