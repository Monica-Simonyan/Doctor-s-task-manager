package ui.PopupWindows;

import model.exceptions.*;
import model.patient.PersonalInformation;
import ui.HomePage;
import ui.PopupItems.DatePicker;
import ui.PopupItems.GenderRadioButtons;
import ui.Menus.PatientCategoryMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static ui.PopupItems.TimePicker.placeTimeComponents;

public class AddPatientPopup extends JDialog {
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField ageField;
    private String gender;


    private final JTextField gmailField;
    private final JTextField addressField;
    private final JTextField phoneNumberField;

    public AddPatientPopup() {
        JPanel panel = new JPanel(new GridLayout(11, 2, 0, 5));
        panel.setBorder(new EmptyBorder(0, 5, 0, 0));
        panel.setPreferredSize(new Dimension(400, 550));


        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        GenderRadioButtons genderRadioButtons = new GenderRadioButtons();
        panel.add(genderRadioButtons.maleRadioButton);
        panel.add(genderRadioButtons.femaleRadioButton);
        panel.add(new JLabel("Gmail:"));
        gmailField = new JTextField();
        panel.add(gmailField);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("Date: "));
        JPanel datePanel = new JPanel();
        datePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        DatePicker datePicker = new DatePicker();
        datePicker.placeComponents(datePanel);
        panel.add(datePanel);

        panel.add(new JLabel("Time: "));
        JPanel timePanel = new JPanel();
        timePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        placeTimeComponents(timePanel);
        panel.add(timePanel);

        panel.add(new JLabel("Choose: "));
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
                    gender = genderRadioButtons.getSelectedGender();
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


