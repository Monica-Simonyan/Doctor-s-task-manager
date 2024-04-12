package patient.FeeManagement;

import java.util.ArrayList;

public interface AddFeeStrategy {
    public void addFee(ArrayList<Payments.Fee> fees, Payments.Fee fee);
}
