package ui;

import model.patient.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PatientCard extends JFrame {
    ArrayList<Patient> patients;

    public PatientCard() {
        AddButton addButton = new AddButton();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientPopup();
            }
        });
        JFrame frame = new JFrame();
        if (patients != null)
            for (Patient p : patients) {
                JLabel info = new JLabel(p.getPersonalInfo().toString());
            }
frame.add(addButton);
        frame.setSize(new Dimension(300, 500));
        frame.setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientCard();
    }
}


