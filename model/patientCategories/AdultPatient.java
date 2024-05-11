package model.patientCategories;

import model.patient.Patient;
/**
 * The AdultPatient class represents an adult patient.
 * It extends the Patient class and provides specific functionalities or attributes
 * tailored for adult patients.
 */
public class AdultPatient extends Patient {
    /**
     * Constructs a new AdultPatient object with default values.
     */
    public AdultPatient() {
        super();
    }
    /**
     * Returns a string representation of the AdultPatient object.
     *
     * @return a string representation of the AdultPatient object
     */
    public String toString() {
        return "Adult";
    }
}
