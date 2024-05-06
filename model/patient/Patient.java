package model.patient;

import java.util.Date;

public abstract class Patient implements Cloneable, DiscountCalculation {
    // Instance variables
    private final int DISCOUNT = 10;
    private PersonalInformation personalInfo;
    private History history;
    private Payments payments;
    private Date nextVisitDate;
    private String imageURL;

    // Constructors
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
        this.history = history.clone();
    }

    public PersonalInformation getPersonalInfo() {
        return new PersonalInformation(personalInfo);
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
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

    public int countPaidFee() {
        int total = countTotalFees();
        for (Payments.Fee fee : payments.getFees()) {
            if (fee.getWasPaid()) {
                total += fee.getAmount();
            }
        }
        return total;
    }

    int countUnpaid() {
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

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        else return this.personalInfo.equals(((Patient) obj).personalInfo);
    }

    public void applyDiscount(Payments.Fee fee) {
        if (fee.getAmount() >= 20000) {
            fee.setAmount(fee.getAmount() - getDISCOUNT());
        }
    }

    // Overridden methods
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n" + getPersonalInfo() + "\n" + history + "\n" + payments + "\n" + nextVisitDate;
    }
}
