package ui;

import model.exceptions.*;
import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.DatePicker.placeComponents;
import static ui.TimePicker.placeTimeComponents;

public class AddPatientPopup extends JDialog {
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField ageField;
    private String gender;

    private final JRadioButton maleRadioButton;
    private final JRadioButton femaleRadioButton;
    private final JTextField gmailField;
    private final JTextField addressField;
    private final JTextField phoneNumberField;

    public AddPatientPopup() {
        JPanel panel = new JPanel(new GridLayout(11, 2, 0, 5));
        panel.setBorder(new EmptyBorder(0,5,0,0));
        panel.setPreferredSize(new Dimension(400, 550));

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

        ButtonGroup genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selected=(JRadioButton)e.getSource();
                gender=selected.getText();
            }
        });
        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selected=(JRadioButton)e.getSource();
                gender=selected.getText();
            }
        });
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);

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
        // Adding OK and Cancel buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        okButton.addActionListener(e -> {
            boolean isInputValid = false;
            PersonalInformation info;
            while (!isInputValid) {

                isInputValid = true;
                try {
                    info = new PersonalInformation(firstNameField.getText(), lastNameField.getText(),
                            ageField.getText(), gmailField.getText(), addressField.getText(),
                            phoneNumberField.getText(), gender);
                    categoriesMenu.accessCategory().setPersonalInfo(info);
                    HomePage.update(categoriesMenu.accessCategory());
                } catch (InvalidPhoneNumberException | InvalidAgeException | InvalidGenderException |
                         InvalidGmailException | InvalidPatientException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

            dispose();
        });
        cancelButton.addActionListener(e -> dispose());
        panel.add(okButton);
        panel.add(cancelButton);

        getContentPane().add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


