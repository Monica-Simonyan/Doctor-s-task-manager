package patientCategories;

import patient.Discount;
import patient.Payments;
import patient.Patient;

import java.util.ArrayList;

public class MinorPatient extends Patient implements Discount{
    private String motherGuardianName;
    private String fatherGuardianName;
    private String motherPhoneNumber;
    private String fatherGuardianPhoneNumber;

    //Accessors and mutators
    public String getMotherGuardianName() {
        return motherGuardianName;
    }

    public void setMotherGuardianName(String motherGuardianName) {
        this.motherGuardianName = motherGuardianName;
    }

    public String getFatherGuardianName() {
        return fatherGuardianName;
    }

    public void setFatherGuardianName(String fatherGuardianName) {
        this.fatherGuardianName = fatherGuardianName;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public String getFatherGuardianPhoneNumber() {
        return fatherGuardianPhoneNumber;
    }

    public void setFatherGuardianPhoneNumber(String fatherGuardianPhoneNumber) {
        this.fatherGuardianPhoneNumber = fatherGuardianPhoneNumber;
    }

    /**Adds fee to the ArrayList of fees in Payments
     *
     * @param fees ArrayList of fees of type Payments.Fee
     * @param fee fee of type Payments.Fee
     */
    public void addFee(ArrayList<Payments.Fee> fees, Payments.Fee fee) {
        fee.setAmount(applyDiscount(fee.getAmount()));
        fees.add(fee);
    }

    /**Applied discount to the given amount of money
     *
     * @param amount integer amount of money
     * @return integer amount of money with discount applied
     */
    public int applyDiscount(int amount) {
        amount*=0.2;
        return amount;
    }
}
