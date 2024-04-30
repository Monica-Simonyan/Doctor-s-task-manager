package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


public class PatientList extends JFrame {
    static final int WIDTH = 300;
    static final int HEIGHT = 600;
    ArrayList<Patient> patients;

    public PatientList() {

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(listPanel);

        // Set up scrolling options
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        // Add the scroll pane to the frame
        add(scrollPane);
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mno", "lastName", 14, PersonalInformation.Gender.FEMALE));


        AddButton addButton = new AddButton(50, listPanel);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds(WIDTH - 70, HEIGHT - 90, 50, 50);
        add(addButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new GridLayout(0, 1));
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Patient List");
    }

    public static void main(String[] args) {
        new PatientList();
    }
}



