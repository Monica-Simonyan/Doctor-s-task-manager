package ui.Elements;

import model.patient.Patient;
import model.patient.Payments;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.util.ArrayList;

public class SearchBar extends JFrame {
    ArrayList<Patient> patients;
    PersonalInformation info;
    JTextField search;


    /**
     * Constructs the searchbar.
     */
    public SearchBar(ArrayList<Patient> patients) {
        this.patients = patients;
        search = new JTextField(30);
    }

    /**
     * Finds a specific patient for the list of all patients
     *
     * @param name the name of the searched patient
     */
    public void findPatient(String name) {
        try {
            for (int i = 0; i < patients.size(); i++) {
                if (info == null) {
                    throw new NullPointerException();
                }
                if (info.getName().equals(name)) {
                    System.out.println("FOUND!!!");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
