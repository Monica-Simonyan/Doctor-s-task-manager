package model.utilities;

import model.patient.Patient;

import java.util.Comparator;

/**
 * The DateComparator class implements a comparator for comparing patients based on their ages.
 * It compares patients by their visited dates.
 */
public class DateComparator implements Comparator<Patient> {
    /**
     * Compares two patients based on their date.
     *
     * @param p1 the first patient to compare
     * @param p2 the second patient to compare
     * @return a negative integer, zero, or a positive integer as the visited date of the first patient
     *         is less than, equal to, or greater than the visited date of the second patient
     */
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.getNextVisitDate().compareTo(p2.getNextVisitDate());
    }
}

