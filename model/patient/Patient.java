package model.patient;

import model.utilities.DiscountCalculation;

import java.util.Date;

public abstract class Patient implements Cloneable, DiscountCalculation, Comparable<Patient> {
    // Instance variables
    private static final int DISCOUNT = 1000;
    private PersonalInformation personalInfo;
    private History history;
    private Payments payments;
    private Date nextVisitDate;
    private String imageURL;
    public static int count;

    // Constructors
    public Patient() {
        this.imageURL = "src/ui/DefaultImages/Adult.png";
        personalInfo = new PersonalInformation();
        history = new History();
        // nextVisitDate = new Date();
        payments = new Payments();
        count++;
    }

    public Patient(PersonalInformation personalInfo, History history, Payments payments, String imageURL) {
        this.imageURL = imageURL;
        setPersonalInfo(personalInfo);
        setHistory(history);
        setPayments(payments);
        count++;
    }

    // Accessors and mutators
    public int getDISCOUNT() {
        return DISCOUNT;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = new Payments(payments);
    }

    public History getHistory() {
        return history.clone();
    }

    public void setHistory(History history) {
        if (history != null)
            this.history = history;
    } //Shallow

    public PersonalInformation getPersonalInfo() {
        return new PersonalInformation(personalInfo);
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        if (personalInfo != null)
            this.personalInfo = new PersonalInformation(personalInfo);
    }

    public Date getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    // Methods
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

    public int countTotalFees() {
        int total = 0;
        for (Payments.Fee fee : payments.getFees()) {
            total += fee.getAmount();
        }
        return total;
    }

    public int countPaidFees() {
        int total = countTotalFees();
        for (Payments.Fee fee : payments.getFees()) {
            if (fee.getWasPaid()) {
                total += fee.getAmount();
            }
        }
        return total;
    }

    public int countUnpaidFees() {
        int total = 0;
        for (Payments.Fee fee : payments.getFees()) {
            if (!fee.getWasPaid()) {
                total += fee.getAmount();
            }
        }
        return total;
    }

    public void addDiscountedFee(Payments.Fee fee) {
        applyDiscount(fee);
        payments.addFee(fee);
    }

    public void applyDiscount(Payments.Fee fee) {
        if (fee.getAmount() >= 50000) {
            fee.setAmount(fee.getAmount() - getDISCOUNT());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        else return this.personalInfo.equals(((Patient) obj).personalInfo);
    }

    public String printPatient() {
        return this + "\n" + getPersonalInfo() + "\n" + history + "\n" + payments + "\n" + nextVisitDate;
    }

    // Overridden methods
    @Override
    public String toString() {
        return getClass().toString();
    }
}