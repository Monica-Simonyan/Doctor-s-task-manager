package com.example.doctorstaskmanagerapplication.patient.patientCategory;

import com.example.doctorstaskmanagerapplication.patient.Patient;

public class PregnantPatient extends Patient implements Cloneable{
    private int trimester;
    private String contraindications;

    public PregnantPatient(String name, String age, String lastDate, String history, int image) {
        super(name, age, lastDate, history, image);
    }
}