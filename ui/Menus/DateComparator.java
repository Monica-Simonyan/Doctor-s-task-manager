package ui.Menus;

import model.patient.Patient;

import java.util.Comparator;

public class DateComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.getNextVisitDate().compareTo(p2.getNextVisitDate());
    }
}

