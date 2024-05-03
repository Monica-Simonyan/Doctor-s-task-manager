
package ui;

import model.exceptions.InvalidPatientException;
import model.patient.Patient;
import model.patientCategories.AdultPatient;
import model.patientCategories.MinorPatient;
import model.patientCategories.PregnantPatient;
import ui.Buttons.AddButton;
import ui.PopupWindows.AddPatientPopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * The HomePage class represents the main user interface for managing patient information.
 * It provides functionality for displaying a list of patients, searching for specific patients,
 * and adding new patients.
 */
public class HomePage extends JFrame {
    private static JPanel patientListPanel;
    private static ArrayList<Patient> patients = new ArrayList<>();
    static final int WIDTH = 350;
    static final int HEIGHT = 650;


    /**
     * Constructs a new HomePage object.
     */
    public HomePage() {
        patientListPanel = new JPanel();
        patientListPanel.setLayout(new GridLayout(1000, 1, 0, 5));
        patientListPanel.setBackground(new Color(255, 255, 255, 255));

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
            new AddPatientPopup();
        });
        addButton.setBounds(270, 10, 40, 40);
        add(addButton);

        JScrollPane scrollPane = new JScrollPane(patientListPanel);
        scrollPane.setBounds(0, 70, WIDTH, 550);
        add(scrollPane);

        //TESTING
        PregnantPatient p = new PregnantPatient();
        AdultPatient a = new AdultPatient();
        MinorPatient m = new MinorPatient();
        try {
            update(p);
            update(a);
            update(m);
        } catch (InvalidPatientException e) {
            throw new RuntimeException(e);
        }
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Patient List");
        setVisible(true);
    }

    /**
     * Adds a patient to the list of patients.
     *
     * @param patient The patient to be added.
     */

    /**
     * Updates the patient list panel with the latest patient information.
     */
    public static void update(Patient patient) throws InvalidPatientException {
        if (patients.contains(patient))
            throw new InvalidPatientException();
        patients.add(patient);
        patientListPanel.add(new PatientListItem(patient));
    }

    public static ArrayList<Patient> accessPatients() {
        return patients;
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
