package com.example.doctorstaskmanagerapplication.exceptions;

public class CannotAddPatientException extends Exception{
    public CannotAddPatientException(){
        super();
    }

    public CannotAddPatientException(String message){
        super(message);
    }
}
