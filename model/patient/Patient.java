package model.patient;

import model.utilities.DiscountCalculation;

import java.util.Date;
/**
 * The Patient class represents a patient in a healthcare system.
 * It provides functionality for managing patient information, history, payments,
 * and next visit dates, as well as methods for calculating fees, applying discounts,
 * and comparing patients.
 */
public abstract class Patient implements Cloneable, DiscountCalculation, Comparable<Patient> {
    // Instance variables
    private static final int DISCOUNT = 1000;
    private PersonalInformation personalInfo;
    private History history;
    private Payments payments;
    private Date nextVisitDate;
    private String imageURL;
    public static int count;
    /**
     * Constructs a new Patient object with default values.
     */
    public Patient() {
        this.imageURL = "src/ui/DefaultImages/Adult.png";
        personalInfo = new PersonalInformation();
        history = new History();
        // nextVisitDate = new Date();
        payments = new Payments();
        count++;
    }
    /**
     * Constructs a new Patient object with the specified parameters.
     *
     * @param personalInfo the personal information of the patient
     * @param history the medical history of the patient
     * @param payments the payment information of the patient
     * @param imageURL the URL of the patient's image
     */

    public Patient(PersonalInformation personalInfo, History history, Payments payments, String imageURL) {
        this.imageURL = imageURL;
        setPersonalInfo(personalInfo);
        setHistory(history);
        setPayments(payments);
        count++;
    }
    /**
     * Retrieves the discount amount applicable to the patient.
     *
     * @return the discount amount
     */
    public int getDISCOUNT() {
        return DISCOUNT;
    }
    /**
     * Retrieves the payments information of the patient.
     *
     * @return the payments information
     */
    public Payments getPayments() {
        return payments;
    }
    /**
     * Sets the payments information of the patient.
     *
     * @param payments the new payments information
     */
    public void setPayments(Payments payments) {
        this.payments = new Payments(payments);
    }
    /**
     * Retrieves a shallow copy of the medical history of the patient.
     *
     * @return a shallow copy of the medical history
     */
    public History getHistory() {
        return history.clone();
    }
    /**
     * Sets the medical history of the patient.
     *
     * @param history the new medical history
     */
    public void setHistory(History history) {
        if (history != null)
            this.history = history;
    }
    /**
     * Retrieves a deep copy of the personal information of the patient.
     *
     * @return a deep copy of the personal information
     */
    public PersonalInformation getPersonalInfo() {
        return new PersonalInformation(personalInfo);
    }
    /**
     * Sets the personal information of the patient.
     *
     * @param personalInfo the new personal information
     */
    public void setPersonalInfo(PersonalInformation personalInfo) {
        if (personalInfo != null)
            this.personalInfo = new PersonalInformation(personalInfo);
    }
    /**
     * Retrieves the next visit date of the patient.
     *
     * @return the next visit date
     */
    public Date getNextVisitDate() {
        return nextVisitDate;
    }
    /**
     * Sets the next visit date of the patient.
     *
     * @param nextVisitDate the new next visit date
     */
    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    /**
     * Retrieves the URL of the patient's image.
     *
     * @return the URL of the patient's image
     */
    public String getImageURL() {
        return imageURL;
    }
    /**
     * Sets the URL of the patient's image.
     *
     * @param imageURL the new URL of the patient's image
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    /**
     * Compares this patient with another patient based on their personal information
     * (name, last name, age) and next visit date.
     *
     * @param other the patient to compare with
     * @return a negative integer, zero, or a positive integer as this patient is less than,
     *         equal to, or greater than the specified patient
     */
    public int compareTo(Patient other) {
        if (!((this.personalInfo.getName()).equals(other.personalInfo.getName())))
            return this.personalInfo.getName().compareTo(other.personalInfo.getName());
        else if (!((this.personalInfo.getLastName()).equals(other.personalInfo.getLastName())))
            return this.personalInfo.getLastName().compareTo(other.personalInfo.getLastName());
        else if (this.personalInfo.getAge() != other.personalInfo.getAge())
            return this.personalInfo.getAge() - other.personalInfo.getAge();
        else if (!(getNextVisitDate().equals(other.getNextVisitDate())))
            return getNextVisitDate().compareTo(other.getNextVisitDate());
        return 0;
    }
    /**
     * Creates and returns a clone of this patient.
     *
     * @return a clone of this patient
     */
    public Patient clone() {
        try {
            Patient clone = (Patient) super.clone();
            clone.history = history.clone();
            clone.personalInfo = personalInfo.clone();
            clone.payments = new Payments(payments);
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    /**
     * Counts the total fees associated with the patient.
     *
     * @return the total fees
     */

    public int countTotalFees() {
        int total = 0;
        for (Payments.Fee fee : payments.getFees()) {
            total += fee.getAmount();
        }
        return total;
    }
    /**
     * Counts the total amount of paid fees by the patient.
     *
     * @return the total amount of paid fees
     */
    public int countPaidFees() {
        int total = countTotalFees();
        for (Payments.Fee fee : payments.getFees()) {
            if (fee.getWasPaid()) {
                total += fee.getAmount();
            }
        }
        return total;
    }
    /**
     * Counts the total amount of unpaid fees by the patient.
     *
     * @return the total amount of unpaid fees
     */

    public int countUnpaidFees() {
        int total = 0;
        for (Payments.Fee fee : payments.getFees()) {
            if (!fee.getWasPaid()) {
                total += fee.getAmount();
            }
        }
        return total;
    }
    /**
     * Adds a discounted fee to the patient's payments.
     *
     * @param fee the fee to be added
     */
    public void addDiscountedFee(Payments.Fee fee) {
        applyDiscount(fee);
        payments.addFee(fee);
    }
    /**
     * Applies a discount to the specified fee if it meets the criteria.
     *
     * @param fee the fee to which the discount will be applied
     */
    public void applyDiscount(Payments.Fee fee) {
        if (fee.getAmount() >= 50000) {
            fee.setAmount(fee.getAmount() - getDISCOUNT());
        }
    }
    /**
     * Checks if this patient is equal to another object.
     *
     * @param obj the object to compare with this patient
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        else return this.personalInfo.equals(((Patient) obj).personalInfo);
    }
    /**
     * Generates a string representation of the patient.
     *
     * @return a string representation of the patient
     */
    public String printPatient() {
        return this + "\n" + getPersonalInfo() + "\n" + history + "\n" + payments + "\n" + nextVisitDate;
    }
    /**
     * Returns a string representation of the class.
     *
     * @return a string representation of the class
     */
    @Override
    public String toString() {
        return getClass().toString();
    }
}