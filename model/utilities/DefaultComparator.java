package model.utilities;

import model.patient.Patient;

import java.util.Comparator;
/**
 * The DefaultComparator class implements a comparator for comparing patients
 * using the default comparison logic provided by the Patient class.
 * It delegates the comparison to the compareTo method of the Patient class.
 */
public class DefaultComparator implements Comparator<Patient> {
    /**
     * Compares two patients using the default comparison logic provided by the Patient class.
     * It delegates the comparison to the compareTo method of the Patient class.
     *
     * @param p1 the first patient to compare
     * @param p2 the second patient to compare
     * @return a negative integer, zero, or a positive integer as the first patient
     *         is less than, equal to, or greater than the second patient
     */
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.compareTo(p2);
    }
}