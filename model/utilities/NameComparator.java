package model.utilities;

import model.patient.Patient;

import java.util.Comparator;
/**
 * The NameComparator class implements a comparator for comparing patients based on their names.
 * It compares patients by their names extracted from their personal information.
 */
public class NameComparator implements Comparator<Patient> {
    /**
     * Compares two patients using the default comparison logic provided by the Patient class.
     * It delegates the comparison to the compareTo method of the Patient class.
     *
     * @param p1 the first patient to compare
     * @param p2 the second patient to compare
     * @return a negative integer, zero, or a positive integer
     */
    @Override
    public int compare(Patient p1, Patient p2) {
        String name1 = p1.getPersonalInfo().getName() + " " + p1.getPersonalInfo().getLastName();
        String name2 = p2.getPersonalInfo().getName() + " " + p2.getPersonalInfo().getLastName();
        return name1.compareToIgnoreCase(name2);
    }
}
