package ui.Elements;

import model.patient.Patient;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents the searchbar.
 */
public class SearchBar extends JFrame {
    JPanel panel;
    JTextField search;


    /**
     * Constructs the searchbar
     */
    public SearchBar(ArrayList<Patient> patients, JPanel p){
        this.panel = p;
        search = new JTextField(30);
    }



    /**
     * Finds a specific patient from the list of all patients
     * @param name     the name of the searched patient
     */
    public void findPatient(String name, ArrayList<Patient> patients){
        try {
            for(int k = 0; k < patients.size(); k++){
                if(name.equalsIgnoreCase(patients.get(k).getPersonalInfo().getName())){
                    System.out.println("FOUND!!!");
                    disposePatient(panel, patients.get(k));
                }
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Disposes the searched patient if it is found
     * @param panel     the panel of the window
     * @param patient   the searched patient
     */
    private void disposePatient(JPanel panel, Patient patient){
        panel.removeAll();
        panel.add(new PatientListItem(patient));
        panel.revalidate();
        panel.repaint();
    }
}