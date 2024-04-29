package ui;

import javax.swing.*;
import java.awt.*;

public class AddPatientPopup {
    public AddPatientPopup() {
        JPanel panel = new JPanel(new GridLayout(3, 2)); // Create a panel with a grid layout
        panel.setPreferredSize(new Dimension(300, 100));
        // Add labels and text fields for each input
        panel.add(new JLabel("First Name:"));
        JTextField firstNameField = new JTextField();

        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        JTextField lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Age:"));
        JTextField ageField = new JTextField();
        panel.add(ageField);

        // Display the panel in a pop-up window
        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        // Check if the user clicked OK
        if (result == JOptionPane.OK_OPTION) {
            // Retrieve the values from the text fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int age = Integer.parseInt(ageField.getText());

            // Display the collected information
            JOptionPane.showMessageDialog(null, "First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age);
        }
    }
}

