
package ui;

import model.exceptions.*;
import model.patient.Patient;
import model.patient.PersonalInformation;
import model.patientCategories.AdultPatient;
import model.patientCategories.MinorPatient;
import model.patientCategories.PregnantPatient;
import ui.Buttons.AddButton;
import ui.Elements.PatientListItem;
import ui.Menus.*;
import ui.PopupWindows.AddPatientPopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The HomePage class represents the main user interface for managing patient information.
 * It provides functionality for displaying a list of patients, searching for specific patients,
 * and adding new patients.
 */
public class HomePage extends JFrame {
    private static JPanel patientListPanel;
    private static ArrayList<Patient> patients = new ArrayList<>();
    public static final int WIDTH = 350;
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
        searchPanel.add(new SortDropDownMenu());
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
        PersonalInformation i = null;
        PersonalInformation b = null;
        try {
            i = new PersonalInformation("Xanice", "smoth", "23",
                    "@gmail.com", "sdfgdfhgbdhb", "32542354", "male");
            b = new PersonalInformation("Pnna", "Hello", "55",
                    "@gmail.com", "sdfgdfhgbdhb", "32542354", "male");
        } catch (InvalidGenderException e) {
            throw new RuntimeException(e);
        } catch (InvalidGmailException e) {
            throw new RuntimeException(e);
        } catch (InvalidAgeException e) {
            throw new RuntimeException(e);
        } catch (InvalidPhoneNumberException e) {
            throw new RuntimeException(e);
        }
        PregnantPatient p = new PregnantPatient();
        p.setPersonalInfo(i);
        AdultPatient a = new AdultPatient();
        a.setPersonalInfo(b);
        MinorPatient m = new MinorPatient();
        try {
            addPatient(p);
            addPatient(a);
            addPatient(m);
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
     * Sorts the patients list by default.
     */
    public static void sortPatientsByDefault() {
        patients.sort(new DefaultComparator());
        refreshPatientListPanel();
    }
    public static void sortPatientsByAge() {
        patients.sort(new AgeComparator());
        refreshPatientListPanel();
    }
    /**
     * Sorts the patients list by name.
     */
    public static void sortPatientsByName() {
        patients.sort(new NameComparator());
        refreshPatientListPanel();
    }

    /**
     * Sorts the patients list by date.
     */
    public static void sortPatientsByDate() {
        patients.sort(new DateComparator());
        refreshPatientListPanel();
    }

    /**
     * Refreshes the patient list panel after sorting.
     */
    private static void refreshPatientListPanel() {
        patientListPanel.removeAll();
        for (Patient patient : patients) {
            patientListPanel.add(new PatientListItem(patient));
        }
        patientListPanel.revalidate();
        patientListPanel.repaint();
    }

    /**
     * Adds a patient to the list of patients.
     *
     * @param patient The patient to be added.
     */

    /**
     * addPatients the patient list panel with the latest patient information.
     */
    public static void addPatient(Patient patient) throws InvalidPatientException {
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
