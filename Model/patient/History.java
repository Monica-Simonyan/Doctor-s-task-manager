package Model.patient;

import Model.patientCategories.utilities.Utility;

import java.util.ArrayList;

/**Class History represents allergies, prescriptions and procedures of a patient
 *
 */

public class History extends Utility implements Cloneable{
    //Instance variables
    private String allergies;
    private ArrayList<String> procedures;
    private String prescriptions;

    public History() {
        procedures = new ArrayList<>();
    }

    /**Copy constructor that creates a new History object as an independent copy of the given object
     *
     * @param that object to be copied of type History
     */
    public History(History that) {
        this.allergies = that.allergies;
        this.prescriptions = that.prescriptions;
        this.procedures = (ArrayList<String>) that.procedures.clone();
    }

    /**Returns allergies
     *
     * @return allergies of type String
     */
    public String getAllergies() {
        return allergies;
    }

    public ArrayList<String> getProcedures() {
        return procedures;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void addProcedures(String... procedure) {
        procedures = appendElementsToArrayList(procedures, procedure);
    }


    public History clone() {
        try {
            History clone = (History) super.clone();
            clone.procedures = new ArrayList<>();
            for(String procedure: procedures){
                clone.procedures.add(procedure);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}