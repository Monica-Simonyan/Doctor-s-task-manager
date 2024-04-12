package com.example.doctorstaskmanagerapplication.patient.patientCategory;


import com.example.doctorstaskmanagerapplication.patient.Patient;

public class AdultPatient extends Patient implements Cloneable{
    public AdultPatient(String name, String age, String lastDate, String history, int image) {
        super(name, age, lastDate, history, image);
    }
}