package ui.PopupWindows;

import model.exceptions.*;
import model.patient.Patient;
import model.patient.PersonalInformation;
import model.patientCategories.AdultPatient;
import model.patientCategories.MinorPatient;
import model.patientCategories.PregnantPatient;
import ui.HomePage;
import ui.Elements.DatePicker;
import ui.Elements.GenderRadioButtons;
import ui.Menus.PatientCategoryMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

import static ui.Elements.TimePicker.placeTimeComponents;

/**
 * AddPatientPopup is a dialog window for adding a new patient's information.
 */
public class AddPatientPopup extends JDialog {

    // Text fields for entering patient information
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField ageField;
    private final JTextField gmailField;
    private final JTextField addressField;
    private final JTextField phoneNumberField;
    private final PatientCategoryMenu categoriesMenu;
    private final GenderRadioButtons genderRadioButtons;
    DatePicker datePicker;

    PregnantPatient p;
    AdultPatient a;
    MinorPatient m;
    Patient patient;

    /**
     * Constructs the AddPatientPopup dialog.
     */
    public AddPatientPopup() {
        JPanel panel = new JPanel(new GridLayout(11, 2, 0, 5));
        panel.setBorder(new EmptyBorder(0, 5, 0, 0));
        panel.setPreferredSize(new Dimension(400, 500));

        // First Name
        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        // Last Name
        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        // Age
        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        // Gmail
        panel.add(new JLabel("Gmail:"));
        gmailField = new JTextField();
        panel.add(gmailField);

        // Address
        panel.add(new JLabel("Address:"));
        addressField = new JTextField();
        panel.add(addressField);

        // Phone Number
        panel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        panel.add(phoneNumberField);


        // Gender selection
        panel.add(new JLabel("Gender: "));
        genderRadioButtons = new GenderRadioButtons();
        JPanel radioBtns = new JPanel();
        radioBtns.add(genderRadioButtons.maleRadioButton);
        radioBtns.add(genderRadioButtons.femaleRadioButton);
        panel.add(radioBtns);

        // Date selection
        panel.add(new JLabel("Date: "));
        JPanel datePanel = new JPanel();
        datePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        DatePicker datePicker = new DatePicker();
        datePicker.placeComponents(datePanel);
        panel.add(datePanel);

        // Time selection
        panel.add(new JLabel("Time: "));
        JPanel timePanel = new JPanel();
        timePanel.setBorder(new EmptyBorder(11, 0, 0, 0));
        placeTimeComponents(timePanel);
        panel.add(timePanel);

        // Category selection
        panel.add(new JLabel("Choose: "));
        categoriesMenu = new PatientCategoryMenu();
        panel.add(categoriesMenu);

        // OK and Cancel buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        okButton.addActionListener(e -> {
            createFile();
//            boolean isInputValid = false;
//            PersonalInformation info;
//            while (!isInputValid) {
//                isInputValid = true;
//                try {
//                    gender = genderRadioButtons.getSelectedGender();
//                    info = new PersonalInformation(firstNameField.getText(), lastNameField.getText(),
//                            ageField.getText(), gmailField.getText(), addressField.getText(),
//                            phoneNumberField.getText(), gender);
//                    categoriesMenu.accessCategory().setPersonalInfo(info);
//                    categoriesMenu.accessCategory().setNextVisitDate(datePicker.getSelectedDate());
//                    HomePage.addPatient(categoriesMenu.accessCategory());
//                } catch (InvalidPhoneNumberException | InvalidAgeException | InvalidGenderException |
//                         InvalidGmailException | InvalidPatientException ex) {
//                    JOptionPane.showMessageDialog(null, ex.getMessage());
//                }
//            }
            addPatientToList();
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

    private void createFile() {
        String file = firstNameField.toString() + lastNameField.toString();
        File fileName1 = new File("src/ui/PatientFiles/" + file + "allergies.txt");
        File fileName2 = new File("src/ui/PatientFiles/" + file + "prescriptions.txt");

        try {
            if (fileName1.createNewFile()) {
                System.out.println("File created!");
            }
            if (!(fileName2.createNewFile())) {
                System.out.println("File created!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addPatientToList() {
        PersonalInformation info;
        try {
            String gender = genderRadioButtons.getSelectedGender();
            info = new PersonalInformation(firstNameField.getText(), lastNameField.getText(),
                    ageField.getText(), gmailField.getText(), addressField.getText(),
                    phoneNumberField.getText(), gender);
            categoriesMenu.accessCategory().setPersonalInfo(info);
            categoriesMenu.accessCategory().setNextVisitDate(datePicker);
            HomePage.addPatient(categoriesMenu.accessCategory());
        } catch (InvalidPhoneNumberException | InvalidAgeException | InvalidGenderException |
                 InvalidGmailException | InvalidPatientException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}