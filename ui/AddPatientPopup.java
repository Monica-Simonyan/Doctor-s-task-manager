package ui;

import model.patient.PersonalInformation;

import model.patientCategories.DateTimePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatientPopup extends JDialog {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JTextField genderField;

    public AddPatientPopup(JPanel container) {
        //   super(parent, "Enter Information", true);
        JPanel panel = new JPanel(new GridLayout(5, 2)); // Create a panel with a grid layout
        panel.setPreferredSize(new Dimension(300, 150));

        // Add labels and text fields for each input
        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);
//panel.add(new DateTimePicker());
        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);

        // Add OK and Cancel buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Custom behavior for OK button
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = genderField.getText();
                // Display the collected information
                container.add(new PatientListItem(firstName, lastName, age, PersonalInformation.Gender.valueOf(gender.toUpperCase())));
                dispose(); // Close the dialog
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog without saving
            }
        });
        panel.add(okButton);
        panel.add(cancelButton);

        // Display the panel in the dialog
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


