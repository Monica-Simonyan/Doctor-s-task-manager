package ui.Elements;

import model.patient.Patient;
import model.patient.Payments;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.util.ArrayList;

public class SearchBar extends JFrame {
    ArrayList<Patient> patients;
    PersonalInformation info;
    Patient patient;
    JTextField search;

    public SearchBar(ArrayList<Patient> patients){
        this.patients = patients;
        search = new JTextField(30);
    }

    public void findPatient(String name){
        try {
            for (int i = 0; i < patients.size(); i++) {
                if (info == null) {
                    throw new NullPointerException();
                }
                if(info.getName().equals(name)){
                    System.out.println("FOUND!!!");
                }
            }
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

}
