package ui;

import model.patient.Patient;
import model.patient.PersonalInformation;

import javax.swing.*;
import java.awt.*;

public class PatientCardPanel extends JPanel {
    public PatientCardPanel(Patient patient){
        PersonalInformation info = patient.getPersonalInfo();
        //change to getImage();
        ImageIcon profile = new ImageIcon("src/ui/149071.png");
        Image image = profile.getImage().getScaledInstance(80, 120, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(image);
        JLabel img = new JLabel(imgIcon);

        JLabel name = new JLabel("Name: " + info.getName());
        name.setFont(new Font("Serif", Font.PLAIN, 15));

    }
}
