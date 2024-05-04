package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InformationPanel extends JPanel {
    public InformationPanel(Patient patient, Color color){
        PersonalInformation info = patient.getPersonalInfo();
        ImageIcon profileImage = new ImageIcon("src/ui/defaultProfileImage.png");
        Image resizedImage = profileImage.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
        JLabel img = new JLabel(resizedImageIcon);

        JLabel category = new JLabel("Category: " + patient);
        JLabel fullNameTxt = new JLabel(info.getName() + " " + info.getLastName());
        JLabel ageTxt = new JLabel("Age: " + info.getAge());
        JLabel genderTxt = new JLabel("Gender: " + info.getGender().toString().toLowerCase());
        setLayout(new GridLayout(6, 2));

        setBackground(color);
        add(category);
        add(fullNameTxt);
        add(ageTxt);
        add(genderTxt);
    }
}
