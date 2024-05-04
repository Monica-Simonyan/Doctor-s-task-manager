package model.patient;

import java.util.Date;

public abstract class Patient implements Cloneable {
    //instance variables
    private PersonalInformation personalInfo;
    private History history;
    private Payments payments;
    private Date nextVisitDate;
    private String imageURL;

    public Patient() {
        this.imageURL = "src/ui/DefaultImages/Adult.png";
        personalInfo = new PersonalInformation();
        history = new History();
        nextVisitDate = new Date();
        payments = new Payments();
    }

    public Patient(PersonalInformation personalInfo, History history, Payments payments, String imageURL) {
        this.imageURL = imageURL;
        setPersonalInfo(personalInfo);
        setHistory(history);
        setPayments(payments);
    }

    //Accessors and mutators

    /**
     * Returns payments of the patient
     *
     * @return payments of type Payments
     */
    public Payments getPayments() {
        return payments.clone();
    }

    /**
     * Sets the payments of the patient
     *
     * @param payments new payments of type Payments
     */
    public void setPayments(Payments payments) {
        this.payments = payments.clone();
    }

    /**
     * Returns history of the patient
     *
     * @return history of type History
     */
    public History getHistory() {
        return history.clone();
    }

    /**
     * Sets the history of the patient
     *
     * @param history new history of type History
     */
    public void setHistory(History history) {
        this.history = history.clone();
    }

    /**
     * Returns the personal information of the patient
     *
     * @return personal information of type PersonalInformation
     */
    public PersonalInformation getPersonalInfo() {
        return new PersonalInformation(personalInfo);
    }

    /**
     * Sets the personal information of the patient
     *
     * @param personalInfo new personal information of type PersonalInformation
     */
    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInfo = new PersonalInformation(personalInfo);
    }

    public Date getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    /**
     * Creates independent clone of the calling Patient object
     *
     * @return cloned object of type Patient
     */
    public Patient clone() {
        try {
            Patient clone = (Patient) super.clone();
            clone.history = history.clone();
            clone.personalInfo = personalInfo.clone();
            clone.payments = payments.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        else return this.personalInfo.equals(((Patient) obj).personalInfo);

    }

    /**
     * Overridden toString method returns the string representation of a patient
     *
     * @return string representation of a patient
     */
    public String toString() {
        return this.getClass() + "\n" + personalInfo + "\n" + history + "\n" + payments + "\n" + nextVisitDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
