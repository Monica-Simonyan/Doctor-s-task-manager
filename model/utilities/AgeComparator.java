package model.utilities;

import model.patient.Patient;

import java.util.Comparator;
/**
 * The AgeComparator class implements a comparator for comparing patients based on their ages.
 * It compares patients by their ages extracted from their personal information.
 */
public class AgeComparator implements Comparator<Patient> {
    /**
     * Compares two patients based on their ages.
     *
     * @param p1 the first patient to compare
     * @param p2 the second patient to compare
     * @return a negative integer, zero, or a positive integer as the age of the first patient
     *         is less than, equal to, or greater than the age of the second patient
     */
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.getPersonalInfo().getAge() - p2.getPersonalInfo().getAge();
    }
}