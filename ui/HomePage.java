package ui;

import model.patient.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class HomePage extends JFrame {
    private static JPanel patientListPanel;
    private static ArrayList<Patient> patients = new ArrayList<>();
    static final int WIDTH = 350;
    static final int HEIGHT = 650;



    public HomePage() {

        patientListPanel = new JPanel();
        patientListPanel.setLayout(new GridLayout(1000, 1, 0, 5));

        JTextField search = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            // Perform search action here
        });

        JPanel searchPanel = new JPanel();
        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchPanel.setBounds(0, 10, 250, 50);
        add(searchPanel);
        AddButton addButton = new AddButton(40);
        addButton.addActionListener(e -> {
            // Add your action here
            new AddPatientPopup(patientListPanel);
        });
        addButton.setBounds(270, 10, 40, 40);
        add(addButton);

        JScrollPane scrollPane = new JScrollPane(patientListPanel);
        scrollPane.setBounds(0, 70, WIDTH, 550);
        add(scrollPane);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Patient List");
        setVisible(true);
    }

    public static void addPatient(Patient patient){
        patients.add(patient);
    }

    public static void update(){
        for(Patient p : patients)
            patientListPanel.add(new PatientListItem(p.getPersonalInfo()));
    }
    public static void main(String[] args) {
        new HomePage();
    }
}
