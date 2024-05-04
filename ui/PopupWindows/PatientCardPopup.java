package ui.PopupWindows;

import model.patient.Patient;
import model.patient.PersonalInformation;
import ui.InformationPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientCardPopup extends JDialog {
    private static final Color color = new Color(252, 217, 217);
    private static final Color backgroundColor = new Color(222, 227, 235);

    static JPanel dataContainer;
    static JButton saveAllergy, savePrescription;
    static ImageIcon profile, imgIcon;
    static Image image;
    static JLabel img, name, age, gender, lastVisit, nextVisit, phone, email, address, history, allergyLabel, prescLabel;
    static JTextField allergies, prescriptions;
    Patient patient;
    PersonalInformation info;

    public PatientCardPopup(Patient patient) {
        this.info = patient.getPersonalInfo();

        //Contianer for profile image and personal information
        dataContainer = new JPanel();
        profile = new ImageIcon(patient.getImageURL());
        image = profile.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);

        InformationPanel informationPanel = new InformationPanel(patient, new Color(0,0,0,0));
        informationPanel.setBorder(new EmptyBorder(10,20,0,0));

        //
        nextVisit = new JLabel("Next Visit Date: "+ patient.getNextVisitDate().toString().substring(0,19));
        nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));

        phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        phone.setFont(new Font("Serif", Font.PLAIN, 15));

        email = new JLabel("Email Address: " + info.getGmail());
        email.setFont(new Font("Serif", Font.PLAIN, 15));

        address = new JLabel("Address:" + info.getAddress());
        address.setFont(new Font("Serif", Font.PLAIN, 15));

        history = new JLabel("History");
        history.setFont(new Font("Serif", Font.PLAIN, 20));

        allergyLabel = new JLabel("Allergies");
        allergyLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        allergies = new JTextField("List Allergies", 10);
        allergies.setBackground(backgroundColor);

        saveAllergy = new JButton("Save");
        saveAllergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Save")) {
                    JOptionPane.showMessageDialog(null, "Saved");
                    // make allergies seen
                }
            }
        });

        prescLabel = new JLabel("Allergies");
        prescLabel.setFont(new Font("Serif", Font.PLAIN, 18));

        prescriptions = new JTextField("List Prescriptions", 10);
        prescriptions.setBackground(backgroundColor);
        savePrescription = new JButton("Save");
        savePrescription.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                if (s.equals("Save")) {
                    JOptionPane.showMessageDialog(null, "Saved");
                    // make prescriptions seen
                }
            }
        });

        dataContainer.add(img);
        informationPanel.add(nextVisit);
        informationPanel.add(phone);
        informationPanel.add(email);
        dataContainer.add(informationPanel);

        add(dataContainer);
        setPreferredSize(new Dimension(400, 550));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

