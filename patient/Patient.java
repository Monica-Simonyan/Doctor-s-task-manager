package patient;

public abstract class Patient{
    PersonalInformation personalInfo;
    History history;
    Payments payments;

    public Payments getPayments(){
        return payments.clone();
    }
    public void setPayments(Payments newPayments){
        payments = newPayments.clone();
    }

    public History getHistory() {
        return history;
    }
    public void setHistory(History newHistory) {
        history = new History(newHistory);
    }



}
