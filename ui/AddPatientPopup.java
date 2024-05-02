package ui;

import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.DatePicker.placeComponents;
import static ui.TimePicker.placeTimeComponents;

public class AddPatientPopup extends JDialog {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField gmailField;
    private JTextField addressField;
    private JTextField phoneNumberField;

    public AddPatientPopup(JPanel container) {
        //   super(parent, "Enter Information", true);
        JPanel panel = new JPanel(new GridLayout(12, 2, 0, 5)); // Create a panel with a grid layout
        panel.setPreferredSize(new Dimension(400, 500));

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

        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);

        panel.add(new JLabel("Gmail:"));
        gmailField = new JTextField();
        panel.add(gmailField);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        JLabel dateTxt = new JLabel("Date: ");
        dateTxt.setSize(dateTxt.getWidth(), dateTxt.getHeight());
        panel.add(dateTxt);
        JPanel datePanel = new JPanel();

        datePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        placeComponents(datePanel);
        panel.add(datePanel);

        JLabel timeTxt = new JLabel("Time: ");
        timeTxt.setSize(timeTxt.getWidth(), timeTxt.getHeight());
        panel.add(timeTxt);
        JPanel timePanel = new JPanel();

        timePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        placeTimeComponents(timePanel);
        panel.add(timePanel);

        JLabel menuTxt = new JLabel("Choose: ");
        panel.add(menuTxt);
        PatientCategoryMenu categoriesMenu = new PatientCategoryMenu();
        panel.add(categoriesMenu);
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
                String gmail = gmailField.getText();
                String address = addressField.getText();
                String phoneNumber = phoneNumberField.getText();
                boolean isInputValid = false;
                PersonalInformation info = null;
                while (!isInputValid) {

                    isInputValid = true;
                    try {
                        info = new PersonalInformation(firstName, lastName, age, gmail, address,
                                phoneNumber, gender);
                        categoriesMenu.accessCategory();
                        // Display the collected information
                        container.add(new PatientListItem(info));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }

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


