package model.patientCategories;

import model.patient.History;
import model.patient.Patient;
import model.patient.Payments;
import model.patient.PersonalInformation;
/**
 * The MinorPatient class represents an adult patient.
 * It extends the Patient class and provides specific functionalities or attributes
 * tailored for minor patients.
 */
public class MinorPatient extends Patient {
    //instance variables
    private String motherGuardianName;
    private String fatherGuardianName;
    private String motherPhoneNumber;
    private String fatherGuardianPhoneNumber;
    private final int DISCOUNT = 5000;
    /**
     * Constructs a new MinorPatient object with default values.
     */
    public MinorPatient() {
        super();
        setImageURL("src/ui/DefaultImages/Minor.png");
    }

    //Accessors and mutators

    /**
     * Returns the name of mother guardian
     *
     * @return name of mother guardian of type String
     */
    public String getMotherGuardianName() {
        return motherGuardianName;
    }

    /**
     * Sets the name of mother guardian
     *
     * @param motherGuardianName new name of the mother guardian of type String
     */
    public void setMotherGuardianName(String motherGuardianName) {
        this.motherGuardianName = motherGuardianName;
    }

    /**
     * Returns the name of father guardian
     *
     * @return name of father guardian of type String
     */
    public String getFatherGuardianName() {
        return fatherGuardianName;
    }

    /**
     * Sets the name of father guardian
     *
     * @param fatherGuardianName new name of the father guardian of type String
     */
    public void setFatherGuardianName(String fatherGuardianName) {
        this.fatherGuardianName = fatherGuardianName;
    }

    /**
     * Returns the phone number of mother guardian
     *
     * @return phone number of mother guardian of type String
     */
    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    /**
     * Sets the phone number of mother guardian
     *
     * @param motherPhoneNumber new phone number of mother guardian of type String
     */
    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    /**
     * Returns the phone number of father guardian
     *
     * @return phone number of father guardian of type String
     */
    public String getFatherGuardianPhoneNumber() {
        return fatherGuardianPhoneNumber;
    }
    /**
     * Returns the phone number of father guardian
     * @param fatherGuardianPhoneNumber  new phone number of father guardian of type String
     */
    public void setFatherGuardianPhoneNumber(String fatherGuardianPhoneNumber) {
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
    }
    /**
     * Retrieves the discount amount applicable to adult patients.
     *
     * @return the discount amount
     */
    @Override
    public int getDISCOUNT() {
        return DISCOUNT;
    }
    /**
     * Returns a string representation of the MinorPatient object.
     *
     * @return a string representation of the MinorPatient object
     */
    public String toString() {
        return "Minor";
    }


}
