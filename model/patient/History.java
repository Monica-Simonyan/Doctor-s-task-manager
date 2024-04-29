package model.patient;

import java.util.ArrayList;

/**
 * Class History represents allergies, prescriptions and procedures of a patient
 */

public class History implements Cloneable {
    //Instance variables
    private String allergies;
    private ArrayList<String> procedures;
    private String prescriptions;

    public History() {
        procedures = new ArrayList<>();
    }

    /**
     * Copy constructor that creates a new History object as an independent copy of the given object
     *
     * @param that object to be copied of type History
     */
    public History(History that) {
        this.allergies = that.allergies;
        this.prescriptions = that.prescriptions;
        this.procedures = (ArrayList<String>) that.procedures.clone();
    }

    /**
     * Returns allergies
     *
     * @return allergies of type String
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * Returns procedures
     *
     * @return ArrayList of  procedures of typeString
     */
    public ArrayList<String> getProcedures() {
        return procedures;
    }

    /**
     * Returns procedures
     *
     * @return ArrayList of  procedures of typeString
     */
    public String getPrescriptions() {
        return prescriptions;
    }

    /**
     * Adds procedure to the list
     *
     * @param procedure procedure of type String
     */
    public void addProcedures(String procedure) {
        procedures.add(procedure);
    }

    /**
     * Creates independent clone of the calling History object
     *
     * @return cloned object of type History
     */
    public History clone() {
        try {
            History clone = (History) super.clone();
            clone.procedures = new ArrayList<>();
            for (String procedure : procedures) {
                clone.procedures.add(procedure);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void printProcedures() {
        for (String procedure : procedures)
            System.out.println(procedure + "\n");
    }

    /**
     * Overridden toString method returns the string representation of a patient's history
     *
     * @return string representation of a patient's history
     */
    public String toString() {
        return allergies + '\n' + procedures + " " + prescriptions;
    }
}