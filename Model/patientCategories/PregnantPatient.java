package Model.patientCategories;

import Model.patient.Payments;
import Model.patient.Patient;

import java.util.ArrayList;

public class PregnantPatient extends Patient implements Cloneable {
    private int trimester;
    private String contraindications;
    private final double DISCOUNT = 0.2;
    /**
     * Adds the given fee to the list of fees
     *
     * @param fee fee for a procedure of type Fee
     */
    public void addFee(ArrayList<Payments.Fee> fees, Payments.Fee fee) {

    }
}
