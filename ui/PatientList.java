package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
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

        AddButton addButton = new AddButton(50, listPanel);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds( 200, 200, 50, 50);
        JPanel btnP = new JPanel();
        btnP.setSize(WIDTH, addButton.HEIGHT);
        btnP.setLayout(null);
        btnP.add(addButton);
        add(btnP);

        // Add the scroll pane to the frame
        add(scrollPane);
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem( "mo", "lastName", 14, PersonalInformation.Gender.FEMALE));
        listPanel.add(new PatientListItem("mno", "lastName", 14, PersonalInformation.Gender.FEMALE));

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



