package model.utilities;

import model.patient.Patient;

import java.util.Comparator;

public class NameComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        String name1 = p1.getPersonalInfo().getName() + " " + p1.getPersonalInfo().getLastName();
        String name2 = p2.getPersonalInfo().getName() + " " + p2.getPersonalInfo().getLastName();
        return name1.compareToIgnoreCase(name2);
    }
}
