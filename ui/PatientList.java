package ui;

import model.exceptions.InvalidAgeException;
import model.exceptions.InvalidGenderException;
import model.exceptions.InvalidGmailException;
import model.exceptions.InvalidPhoneNumberException;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PatientList extends JFrame {
    JPanel searchPanel;
    JPanel listPanel;
    JTextField search;
    JTextArea area;
    JButton searchButton;
    static final int WIDTH = 350;
    static final int HEIGHT = 650;

    public PatientList() {
        listPanel = new JPanel();
        setLayout(null); // Set null layout for the main frame

        search = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            // Perform search action here
        });

        searchPanel = new JPanel();
        //  searchPanel.add(new JLabel("Find patient..."));
        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchPanel.setBounds(0, 10, 250, 50); // Set bounds for searchPanel
        add(searchPanel);
        ui.AddButton addButton = new ui.AddButton(40, listPanel);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds(270, 10, 40, 40);
        add(addButton);

        listPanel.setLayout(new GridLayout(1000, 1, 0, 5)); // Set grid layout for listPanel

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBounds(0, 70, WIDTH, 550); // Set bounds for scrollPane
        add(scrollPane);

        PersonalInformation info = null ;
        try {
            info = new PersonalInformation("firstName", "lastName", "12", "gmail@gmail.com", "address",
                    "+378989989", "MALE");
        } catch (InvalidPhoneNumberException | InvalidAgeException | InvalidGenderException |
                 InvalidGmailException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));
        listPanel.add(new PatientListItem(info));



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Patient List");
        setVisible(true);
    }

    public static void main(String[] args) {
       new PatientList();
    }
}
