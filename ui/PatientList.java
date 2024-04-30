package ui;

import model.patient.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class PatientList extends JFrame {
    ArrayList<Patient> patients;

    public PatientList() {
        int WIDTH = 300;
        int HEIGHT = 500;
        // Add components to the content pane
        AddButton addButton = new AddButton(50);
        addButton.setBounds(WIDTH - 70, HEIGHT - 90, 50, 50);
        add(addButton);

        // Set frame properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientList();
    }
}



