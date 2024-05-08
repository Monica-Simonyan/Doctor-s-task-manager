package model.utilities;

import model.patient.Patient;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.compareTo(p2);
    }
}