package ui;

import model.patient.Patient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PatientCard extends JFrame {
    ArrayList<Patient> patients;

    public PatientCard() {
        JFrame frame = new JFrame();
        AddButton addButton = new AddButton();
        if (patients != null)
            for (Patient p : patients) {
                JLabel info = new JLabel(p.getPersonalInfo().toString());
            }
        this.setSize(new Dimension(300,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
       this.setBackground(new Color(152, 135, 159));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.getContentPane().add(addButton);
    }

    public static void main(String[] args) {
        new PatientCard();
    }
}


