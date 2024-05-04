package model.patientCategories;

import model.patient.*;

import java.util.ArrayList;

public class PregnantPatient extends Patient implements Discount {
    private int trimester;
    private String contraindications;
    private final double DISCOUNT = 0.2;

    public PregnantPatient() {
        super();
        setImageURL("src/ui/DefaultImages/Pregnant.jpg");
    }

    public PregnantPatient(PersonalInformation personalInfo, History history, Payments payments, int trimester, String contraindications) {
        super(personalInfo, history, payments, "src/ui/DefaultImages/Pregnant.jpg");
        this.trimester = trimester;
        this.contraindications = contraindications;
    }

    public PregnantPatient(int trimester, String contraindications) {
        this.trimester = trimester;
        this.contraindications = contraindications;
    }

    /**
     * Adds the given fee to the list of fees
     *
     * @param fee fee for a procedure of type Fee
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
        if (amount >= 20)
            return (int) (amount * 0.9 - 5);
        else
            return (int) (amount * 0.85);
    }

    public int getTrimester() {
        return trimester;
    }

    public void setTrimester(int trimester) {
        this.trimester = trimester;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }
    public String toString(){
        return "Pregnant";
    }
}
