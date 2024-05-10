package ui.Elements;

import model.exceptions.*;
import model.patient.Patient;
import model.patient.Payments;
import model.patient.PersonalInformation;
import model.patientCategories.AdultPatient;
import model.patientCategories.MinorPatient;
import model.patientCategories.PregnantPatient;
import ui.HomePage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchBar extends JFrame {
    //ArrayList<Patient> patients;
    JPanel panel;
    JTextField search;


    /**
     * Constructs the searchbar
     */
    public SearchBar(ArrayList<Patient> patients, JPanel p){
        //this.patients = new ArrayList<>(patients);
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
                if(name.equals("")){
                    addPatients(patients.get(k));
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

    private void addPatients(Patient patient){
        PersonalInformation i = null;
        try {
            i = new PersonalInformation(patient.getPersonalInfo().getName(), patient.getPersonalInfo().getLastName(), String.valueOf(patient.getPersonalInfo().getAge()),
                    patient.getPersonalInfo().getGmail(), patient.getPersonalInfo().getAddress(), patient.getPersonalInfo().getPhoneNumber(), patient.getPersonalInfo().getGender().toString());
        }
        catch (InvalidGenderException | InvalidGmailException | InvalidAgeException | InvalidPhoneNumberException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            patient.setPersonalInfo(i);
            if (patient.equals("Pregnant")) {
                PregnantPatient p = new PregnantPatient();
                p.setPersonalInfo(i);
                try{
                    HomePage.addPatient(p);
                }
                catch (InvalidPatientException w) {
                    JOptionPane.showMessageDialog(null, w.getMessage());
                }
            }
            if (patient.equals("Minor")) {
                MinorPatient m = new MinorPatient();
                m.setPersonalInfo(i);
                try{
                    HomePage.addPatient(m);
                }
                catch (InvalidPatientException w) {
                    JOptionPane.showMessageDialog(null, w.getMessage());
                }
            } else {
                AdultPatient a = new AdultPatient();
                a.setPersonalInfo(i);
                try{
                    HomePage.addPatient(a);
                }
                catch (InvalidPatientException w) {
                    JOptionPane.showMessageDialog(null, w.getMessage());
                }
            }
        }
    }
}