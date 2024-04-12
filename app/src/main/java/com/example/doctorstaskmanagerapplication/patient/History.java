package com.example.doctorstaskmanagerapplication.patient;

import com.example.doctorstaskmanagerapplication.Utilities.Utility;

import java.util.ArrayList;

public class History extends Utility {
    private String allergies;
    private ArrayList<String> procedures;
    private String prescriptions;

    public History() {
        procedures = new ArrayList<>();
    }

    public History(History that) {
        this.allergies = that.allergies;
        this.prescriptions = that.prescriptions;
        this.procedures = (ArrayList<String>) that.procedures.clone();
    }

    public String getAllergies() {
        return allergies;
    }

    public ArrayList<String> getProcedures() {
        return procedures;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void addProcedures(String... procedure) {
        procedures = appendElementsToArrayList(procedures, procedure);
    }

}