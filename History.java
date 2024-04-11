import Utilities.Utility;

import java.util.ArrayList;
public class History extends Utility {
    private ArrayList<String> allergies;
    private ArrayList<String> procedures;
    private ArrayList<String> prescriptions;

    public History() {
        allergies = new ArrayList<>();
        prescriptions = new ArrayList<>();
        procedures = new ArrayList<>();

    }

    public History(History that) {

    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public ArrayList<String> getProcedures() {
        return procedures;
    }

    public ArrayList<String> getPrescriptions() {
        return prescriptions;
    }

    public void addAllergies(String... allergy) {
        allergies = appendElementsToArrayList(allergies, allergy);
    }

    public void addProcedures(String... procedure) {
        procedures = appendElementsToArrayList(procedures, procedure);
    }

    public void addPrescriptions(String... prescription) {
        prescriptions = appendElementsToArrayList(prescriptions, prescription);
    }
}