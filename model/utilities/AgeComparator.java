package model.utilities;

import model.patient.Patient;

import java.util.Comparator;

public class AgeComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.getPersonalInfo().getAge() - p2.getPersonalInfo().getAge();
    }
}