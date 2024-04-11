import java.util.ArrayList;
import java.util.Collection;

public class Payments implements Cloneable {
    private static class Fee {
        boolean wasPayed;
        int fee;

        public Fee(boolean wasPayed, int fee) {
            this.wasPayed = wasPayed;
            this.fee = fee;
        }

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
    public Payments clone() {
        try {
            Payments clone = (Payments) super.clone();
            ArrayList<Fee> clonedList = new ArrayList<>();
            // Copy mutable state here, so the clone can't change the internals of the original
            for (Fee fee : fees) {
                clonedList.add((Fee) fee.clone()); // Performs deep cloning of each element
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public Payments(ArrayList<Fee> fees) {
        ArrayList<Fee> clonedList = new ArrayList<>();
        for (Fee fee : fees) {
            clonedList.add((Fee) fee.clone()); // Performs deep cloning of each element
        }
    }

    public void addPayment(Fee fee) {
        fees.add(fee);
    }

    public int countTotalFee() {
        int total = 0;
        for (Fee fee : fees) {
            if (!fee.wasPayed) {
                total += fee.fee;
            }
        }
        return total;
    }


}
