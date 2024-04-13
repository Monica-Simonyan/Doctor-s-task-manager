package patient;

import utilities.Utility;

import java.util.ArrayList;

public class History extends Utility implements Cloneable{
    private String allergies;
    private ArrayList<String> procedures;
    private String prescriptions;

    public History() {
        procedures = new ArrayList<>();
    }

    public History(History that) {
        this.allergies = that.allergies;
        this.prescriptions = that.prescriptions;
        this.procedures = (ArrayList<String>) that.procedures.clone();
    }

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