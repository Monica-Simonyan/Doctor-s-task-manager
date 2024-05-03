package ui;

import model.patient.Patient;

import javax.swing.*;

public class PatientFilterMenu extends JMenuBar{
    private Patient category;
    public PatientFilterMenu(){
        JMenu patientMenu = new JMenu("Categories");
        JMenuItem item1 = new JMenuItem("Adult");
        JMenuItem item2 = new JMenuItem("Minor");
        JMenuItem item3 = new JMenuItem("Pregnant");


    }
}
