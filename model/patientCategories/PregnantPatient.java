package model.patientCategories;

import model.patient.Discount;
import model.patient.Patient;
import model.patient.Payments;

import java.util.ArrayList;

public class PregnantPatient extends Patient implements Discount {
    private int trimester;
    private String contraindications;
    private final double DISCOUNT = 0.2;

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
            return (int) (amount*0.85);
    }
}
