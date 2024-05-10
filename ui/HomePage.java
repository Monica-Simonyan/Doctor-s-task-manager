package ui;

import model.exceptions.*;
import model.patient.*;
import model.utilities.*;
import ui.Menus.*;
import model.patientCategories.*;
import ui.Buttons.AddButton;
import ui.Elements.PatientListItem;
import ui.Elements.SearchBar;
import ui.PopupWindows.AddPatientPopup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The HomePage class represents the main user interface for managing patient information.
 * It provides functionality for displaying a list of patients, searching for specific patients,
 * and adding new patients.
 */
public class HomePage extends JFrame {
    private static JPanel patientListPanel;
    private static final ArrayList<Patient> patients = new ArrayList<>();
    public static final int WIDTH = 350;
    static final int HEIGHT = 650;


    /**
     * Constructs a new HomePage object.
     */
    public HomePage() {
        patientListPanel = new JPanel();
        patientListPanel.setLayout(new GridLayout(1000, 1, 0, 5));
        patientListPanel.setBackground(new Color(255, 255, 255, 255));


        SearchBar searchBar = new SearchBar(patients, patientListPanel);
        JTextField search = new JTextField(10);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> searchBar.findPatient(search.getText(), patients));


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
            i = new PersonalInformation("Janice", "Smith", "23",
                    "janice@gmail.com", "Baker street 15", "32542354", "female");
            b = new PersonalInformation("Pnna", "Hello", "55",
                    "@gmail.com", "sdfgdfhgbdhb", "32542354", "male");
        } catch (InvalidGenderException | InvalidGmailException | InvalidAgeException | InvalidPhoneNumberException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Home Page");
        setVisible(true);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                writePatients();
                readPatients();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                writePatients();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
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
     * addPatients the patient list panel with the latest patient information
     */
    public static void addPatient(Patient patient) throws InvalidPatientException {
        if (patients.contains(patient)) {
            throw new InvalidPatientException();
        }
        patients.add(patient);
        patientListPanel.add(new PatientListItem(patient));
    }

    public static ArrayList<Patient> accessPatients() {
        return patients;
    }

    public static void writePatients() {
        for (Patient p : patients) {
            String fileName = p.getPersonalInfo().getName() + p.getPersonalInfo().getLastName();
            try {
                PrintWriter outputStream = new PrintWriter(new FileOutputStream("src/ui/PatientFiles/" + fileName, true));
                outputStream.println(p.printPatient());
                outputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readPatients() {
        StringBuilder str = new StringBuilder();
        for (Patient p : patients) {
            String fileName = p.getPersonalInfo().getName() + p.getPersonalInfo().getLastName();
            try {
                Scanner inputStream = new Scanner(new FileInputStream("src/ui/PatientFiles/" + fileName));
                while (inputStream.hasNextLine()) {
                    str.append(inputStream.nextLine());
                }
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(str);
    }

    public void findPatient(String name) {
        try {

            for (int k = 0; k < patients.size(); k++) {
                System.out.println(patients.get(k).getPersonalInfo().getName());
                if (name.equalsIgnoreCase(patients.get(k).getPersonalInfo().getName())) {
                    System.out.println("FOUND!!!");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}

