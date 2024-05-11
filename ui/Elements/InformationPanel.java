package ui.Elements;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the patients present in the arrayList in the Home Page
 */
public class InformationPanel extends JPanel {

    /**
     * Constructs the information panel
     * @param patient     <code>Patient</code> patient
     * @param color       <code>Color</code> color
     */
    public InformationPanel(Patient patient, Color color) {
        PersonalInformation info = patient.getPersonalInfo();
        JLabel category = new JLabel("Category: " + patient);
        JLabel fullNameTxt = new JLabel(info.getName() + " " + info.getLastName());
        JLabel ageTxt = new JLabel("Age: " + info.getAge());
        JLabel genderTxt = new JLabel("Gender: " + info.getGender().toString().toLowerCase());
        setLayout(new GridLayout(0, 1));

        setBackground(color);
        add(category);
        add(fullNameTxt);
        add(ageTxt);
        add(genderTxt);
    }
}
