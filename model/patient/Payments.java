package model.patient;

import java.util.ArrayList;

/**
 * Represents the payment records for a patient.
 * This class manages a list of fees, tracking both paid and unpaid amounts.
 */
public class Payments {

    /**
     * Represents a specific fee with its payment status and amount.
     */
    public static class Fee implements Cloneable {
        private boolean wasPaid;
        private int amount;

        /**
         * Constructs a Fee with its payment status and amount.
         *
         * @param wasPaid true if the fee has been paid, false otherwise
         * @param amount  the amount of the fee
         */
        public Fee(boolean wasPaid, int amount) {
            this.wasPaid = wasPaid;
            this.amount = amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setWasPaid(boolean wasPaid) {
            this.wasPaid = wasPaid;
        }

        public int getAmount() {
            return amount;
        }

        public boolean getWasPaid() {
            return wasPaid;
        }

        /**
         * Clones this Fee object.
         *
         * @return a clone of this Fee instance
         */
        public Fee clone() {
            try {
                return (Fee) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        public String toString() {
            return amount + " AMD";
        }
    }

    private final ArrayList<Fee> fees;

    /**
     * Default constructor that initializes an empty list of fees.
     */
    public Payments() {
        fees = new ArrayList<>();
    }

    /**
     * Constructs Payments with a list of fees, performing deep copying.
     *
     * @param other a list of fees to initialize the Payments object
     */
    public Payments(Payments other) {
        fees = new ArrayList<>(other.fees.size());
        for (Fee fee : other.fees) {
                fees.add(fee.clone()); // Deep cloning of each Fee
        }
    }

    public void addFee(Fee fee) {
        fees.add(fee);
    }

    /**
     * Gets the list of fees.
     * Note: This method returns a shallow copy of the fees list.
     * Modifications to Fee objects will affect this Payments object.
     *
     * @return a shallow copy of the list of fees
     */
    public ArrayList<Fee> getFees() {
        ArrayList<Fee> copy = new ArrayList<>(fees.size());
        for (Fee fee : fees)
            copy.add(fee.clone());
        return copy;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Fee fee : fees)
            str.append(fee + "\n");
        return str.toString();
    }
}
