import java.util.ArrayList;

/**
 * The class Payments represents payments of a patient
 */
public class Payments implements Cloneable {
    /**
     * Inner class presenting a specific fee paid by patient
     */
    private static class Fee {
        boolean wasPaid;
        int amount;

        /**
         * No argument constructor creates an object Fee with given fee amount wasPid boolean value
         *
         * @param wasPaid true if fee was paid
         * @param amount  amount of fee
         */
        public Fee(boolean wasPaid, int amount) {
            this.wasPaid = wasPaid;
            this.amount = amount;
        }

        /**
         * Overridden clone method
         *
         * @return clone of the calling object of type Fee
         */
        public Fee clone() {
            try {
                return (Fee) super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }

    }

    private ArrayList<Fee> fees;
    /**
     * Overridden clone method
     *
     * @return  deep copy of the calling object of type Payments
     */
    public Payments clone() {
        try {
            Payments clone = (Payments) super.clone();
            ArrayList<Fee> clonedList = new ArrayList<>();
            // Copy mutable state here, so the clone can't change the internals of the original
            for (Fee fee : fees) {
                clonedList.add(fee.clone()); // Performs deep cloning of each element
            }
            clone.fees = clonedList;
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**Constructor that creates an object Payments with given fees
     *
     * @param fees ArrayList<> of fees of base type Fee
     */
    public Payments(ArrayList<Fee> fees) {
        ArrayList<Fee> clonedList = new ArrayList<>();
        for (Fee fee : fees) {
            clonedList.add(fee.clone()); // Performs deep cloning of each element
        }
        this.fees = clonedList;
    }

    /**Adds the given fee to the list of fees
     *
     * @param fee fee for a procedure of type Fee
     */
    public void addFee(Fee fee) {
        fees.add(fee);
    }

    /**Returns total paid fees
     *
     * @return int total paid fees
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
    /**Returns total unpaid fees
     *
     * @return int total unpaid fees
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
}
