package com.example.doctorstaskmanagerapplication;

public class CannotAddPatientException extends Exception{
    public CannotAddPatientException(){
        super();
    }

    public CannotAddPatientException(String message){
        super(message);
    }
}
