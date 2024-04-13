package com.example.doctorstaskmanagerapplication.patient.patientCategory;


import com.example.doctorstaskmanagerapplication.patient.Patient;

public class MinorPatient extends Patient implements Cloneable {
    private String motherGuardianName;
    private String fatherGuardianName;
    private String motherPhoneNumber;
    private String fatherGuardianPhoneNumber;

    public MinorPatient(String name, String age, String lastDate, String history, int image) {
        super(name, age, lastDate, history, image);
    }

    public String getMotherGuardianName() {
        return motherGuardianName;
    }

    public void setMotherGuardianName(String motherGuardianName) {
        this.motherGuardianName = motherGuardianName;
    }

    public String getFatherGuardianName() {
        return fatherGuardianName;
    }

    public void setFatherGuardianName(String fatherGuardianName) {
        this.fatherGuardianName = fatherGuardianName;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public String getFatherGuardianPhoneNumber() {
        return fatherGuardianPhoneNumber;
    }

    public void setFatherGuardianPhoneNumber(String fatherGuardianPhoneNumber) {
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
    }
}