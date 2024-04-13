package Model.patient;

public abstract class Patient implements Cloneable {
    //instance variables
    PersonalInformation personalInfo;
    History history;
    Payments payments;

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
        return history;
    }

    /**
     * Sets the history of the patient
     *
     * @param history new history of type History
     */
    public void setHistory(History history) {
        history = new History(history);
    }

    public Patient clone() {
        try {
            Patient clone = (Patient) super.clone();
            clone.history = history.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
