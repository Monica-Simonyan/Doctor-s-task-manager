package model.patientCategories;

import model.patient.*;

/**
 * Represents a pregnant patient, extending the Patient class.
 */
public class PregnantPatient extends Patient {
    private final int DISCOUNT = 3000;
    private int trimester;
    private String contraindications;

    /**
     * Default constructor for PregnantPatient.
     * Sets default image URL for pregnant patients.
     */
    public PregnantPatient() {
        super();
        setImageURL("src/ui/DefaultImages/Pregnant.png");
    }

    /**
     * Constructs a PregnantPatient with specified parameters.
     *
     * @param personalInfo      personal information of the patient
     * @param history           medical history of the patient
     * @param payments          payment records of the patient
     * @param trimester         current trimester of the pregnancy
     * @param contraindications any contraindications or medical conditions
     */
    public PregnantPatient(PersonalInformation personalInfo, History history, Payments payments, int trimester, String contraindications) {
        super(personalInfo, history, payments, "src/ui/DefaultImages/Pregnant.png");
        this.trimester = trimester;
        this.contraindications = contraindications;
    }

    /**
     * Constructs a PregnantPatient with specified trimester and contraindications.
     *
     * @param trimester         current trimester of the pregnancy
     * @param contraindications any contraindications or medical conditions
     */
    public PregnantPatient(int trimester, String contraindications) {
        this.trimester = trimester;
        this.contraindications = contraindications;
    }

    /**
     * Gets the current trimester of the pregnancy.
     *
     * @return the trimester
     */
    public int getTrimester() {
        return trimester;
    }

    /**
     * Sets the current trimester of the pregnancy.
     *
     * @param trimester the trimester to set
     */
    public void setTrimester(int trimester) {
        this.trimester = trimester;
    }

    /**
     * Gets any contraindications or medical conditions.
     *
     * @return the contraindications
     */
    public String getContraindications() {
        return contraindications;
    }

    /**
     * Sets any contraindications or medical conditions.
     *
     * @param contraindications the contraindications to set
     */
    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    /**
     * Returns a string representation of the PregnantPatient.
     *
     * @return string representation of the PregnantPatient
     */
    public String toString() {
        return "Pregnant" ;
    }

    /**
     * Overrides the getDISCOUNT method to return the discount specific to pregnant patients.
     *
     * @return the discount for pregnant patients
     */
    @Override
    public int getDISCOUNT() {
        return DISCOUNT;
    }
}
