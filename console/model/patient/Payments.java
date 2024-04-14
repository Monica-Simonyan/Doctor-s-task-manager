package console.model.patient;

import java.util.ArrayList;

/**
 * Represents the payment records for a patient.
 * This class manages a list of fees, tracking both paid and unpaid amounts.
 */
public class Payments implements Cloneable {

    /**
     * Represents a specific fee with its payment status and amount.
     */
    protected static class Fee {
        boolean wasPaid;
        int amount;

        /**
         * Constructs a Fee with its payment status and amount.
         *
         * @param wasPaid true if the fee has been paid, false otherwise
         * @param amount the amount of the fee
         */
        public Fee(boolean wasPaid, int amount) {
            this.wasPaid = wasPaid;
            this.amount = amount;
        }

        /**
         * Clones this Fee object.
         * @return a clone of this Fee instance
         */
        @Override
        public Fee clone() {
            try {
                return (Fee) super.clone();
            } catch (CloneNotSupportedException e) {
                return null; // This should never happen since we're Cloneable
            }
        }

        /**
         * Sets the amount of the fee.
         * @param amount the new amount of the fee
         */
        public void setAmount(int amount) {
            this.amount = amount;
        }

        /**
         * Gets the amount of the fee.
         * @return the amount of the fee
         */
        public int getAmount() {
            return amount;
        }
    }

    private ArrayList<Fee> fees;

    /**
     * Default constructor that initializes an empty list of fees.
     */
    public Payments() {
        fees = new ArrayList<>();
    }

    /**
     * Constructs Payments with a list of fees, performing deep copying.
     *
     * @param newFees a list of fees to initialize the Payments object
     */
    public Payments(ArrayList<Fee> newFees) {
        fees = new ArrayList<>(newFees.size());
        for (Fee fee : newFees) {
            fees.add(fee.clone()); // Deep cloning of each Fee
        }
    }

    /**
     * Adds a fee to the list of fees, performing a clone to avoid external modifications.
     * @param fee the Fee to add
     */
    public void addFee(Fee fee) {
        this.fees.add(fee.clone());
    }

    /**
     * Gets the list of fees.
     * Note: This method returns a shallow copy of the fees list.
     * Modifications to Fee objects will affect this Payments object.
     *
     * @return a shallow copy of the list of fees
     */
    public ArrayList<Fee> getFees() {
        return fees; // Note: Shallow copy, internal state modification possible through objects
    }

    /**
     * Calculates the total amount of fees that have been paid.
     *
     * @return the total amount of paid fees
     */
    public int countPaidFee() {
        int total = 0;
        for (Fee fee : fees) {
            if (fee.wasPaid) {
                total += fee.amount;
            }
        }
        return total;
    }

    /**
     * Calculates the total amount of fees that have not been paid.
     *
     * @return the total amount of unpaid fees
     */
    public int countUnpaid() {
        int total = 0;
        for (Fee fee : fees) {
            if (!fee.wasPaid) {
                total += fee.amount;
            }
        }
        return total;
    }

    /**
     * Creates a deep clone of this Payments object, including all fees.
     *
     * @return a deep clone of this Payments object
     */
    @Override
    public Payments clone() {
        try {
            Payments clone = (Payments) super.clone();
            clone.fees = new ArrayList<>();
            for (Fee fee : this.fees) {
                clone.fees.add(fee.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            return null; // This should never happen since we're Cloneable
        }
    }
}
