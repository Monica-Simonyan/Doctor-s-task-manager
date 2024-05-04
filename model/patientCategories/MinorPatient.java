package model.patientCategories;

import model.patient.*;

import java.util.ArrayList;

public class MinorPatient extends Patient implements Discount {
    //instance variables
    private String motherGuardianName;
    private String fatherGuardianName;
    private String motherPhoneNumber;
    private String fatherGuardianPhoneNumber;

    public MinorPatient() {
        super();
        setImageURL("src/ui/DefaultImages/Minor.png");
    }

    public MinorPatient(PersonalInformation personalInfo, History history, Payments payments, String motherGuardianName, String fatherGuardianName, String motherPhoneNumber, String fatherGuardianPhoneNumber) {
        super(personalInfo, history, payments, "src/ui/DefaultImages/Minor.png");
        this.motherGuardianName = motherGuardianName;
        this.fatherGuardianName = fatherGuardianName;
        this.motherPhoneNumber = motherPhoneNumber;
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
    }

    public MinorPatient(String motherGuardianName, String fatherGuardianName, String motherPhoneNumber, String fatherGuardianPhoneNumber) {
        this.motherGuardianName = motherGuardianName;
        this.fatherGuardianName = fatherGuardianName;
        this.motherPhoneNumber = motherPhoneNumber;
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
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

    public void setFatherGuardianPhoneNumber(String fatherGuardianPhoneNumber) {
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
    }

    /**
     * Adds fee to the ArrayList of fees in Payments
     *
     * @param fees ArrayList of fees of type Payments.Fee
     * @param fee  fee of type Payments.Fee
     */
    public void addFee(ArrayList<Payments.Fee> fees, Payments.Fee fee) {
        fee.setAmount(applyDiscount(fee.getAmount()));
        fees.add(fee);
    }

    /**
     * Applied discount to the given amount of money
     *
     * @param amount integer amount of money
     * @return integer amount of money with discount applied
     */
    public int applyDiscount(int amount) {
        amount *= 0.8;
        return amount;
    }

    public String toString(){
        return "Minor";
    }
}
