package ui;

import model.patient.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class PatientList extends JFrame {
    ArrayList<Patient> patients;

    public PatientList() {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(PatientListItem.count, 1));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        // Set up scrolling options
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add the scroll pane to the frame
        add(scrollPane);
        int WIDTH = 300;
        int HEIGHT = 500;
        // Add components to the content pane
        AddButton addButton = new AddButton(50, this);
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



