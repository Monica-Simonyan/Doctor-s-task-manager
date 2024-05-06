package ui.PopupWindows;

import model.patient.*;
import ui.Elements.InformationPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Scanner;

public class PatientCardPopup extends JDialog {
    private static final Color backgroundColor = new Color(222, 227, 235);
    private static String fileName;
    static JPanel dataContainer;
    static JButton saveAllergy, savePrescription;
    static ImageIcon profile, imgIcon;
    static Image image;
    static JLabel img, name, age, gender, nextVisit, phone, email, address, allergyLabel, allergyContent, prescriptionLabel;
    static JTextField allergies, prescriptions;
    private String s;
    Patient patient;
    PersonalInformation info;

    public PatientCardPopup(Patient patient){
        this.patient = patient.clone();
        this.info = this.patient.getPersonalInfo();

        dataContainer = new JPanel();
        profile = new ImageIcon(patient.getImageURL());
        image = profile.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        image = profile.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(image);
        img = new JLabel(imgIcon);
        img.setHorizontalTextPosition(0);
        img.setVerticalTextPosition(0);
        //img.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());

        loadWindow();
    }


    private void loadWindow(){
        InformationPanel informationPanel = new InformationPanel(patient, new Color(0,0,0,0));
        informationPanel.setBorder(new EmptyBorder(10,80,0,0));
        informationPanel.setBorder(new EmptyBorder(10,20,0,0));

        JScrollPane scrollPane = new JScrollPane(informationPanel);
        scrollPane.setBounds(0, 10, WIDTH, 550);
        add(scrollPane);

        name = new JLabel("Name: " + info.getName() + " " + info.getLastName());
        name.setFont(new Font("Serif", Font.PLAIN, 15));

        age = new JLabel("Age: " + info.getAge());
        age.setFont(new Font("Serif", Font.PLAIN, 15));

        gender = new JLabel("Gender: " + info.getGender());
        gender.setFont(new Font("Serif", Font.PLAIN, 15));

        //
        nextVisit = new JLabel();
        nextVisit = new JLabel("Next Visit Date: "+ patient.getNextVisitDate().toString().substring(0,19));
        //nextVisit.setFont(new Font("Serif", Font.PLAIN, 15));

        phone = new JLabel("Phone Number: " + info.getPhoneNumber());
        //phone.setFont(new Font("Serif", Font.PLAIN, 15));

        email = new JLabel("Email Address: " + info.getGmail());
        //email.setFont(new Font("Serif", Font.PLAIN, 15));

        address = new JLabel("Address: " + info.getAddress());
        //address.setFont(new Font("Serif", Font.PLAIN, 15));

        allergyLabel = new JLabel("Allergies");
        allergyContent = new JLabel();
        //allergyLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        allergies = new JTextField("List Allergies", 20);
        allergyContent.setPreferredSize(new Dimension(200, 100));
        allergies.setBackground(backgroundColor);
        saveAllergy = new JButton("Save");
        saveAllergy.addActionListener(e -> {
            s = allergies.getText();
            if (s.equals("Save")) {
                JOptionPane.showMessageDialog(null, "Saved");
                allergyContent.setText(s);
            }
        });

        prescriptionLabel = new JLabel("Allergies");
        //prescriptionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        prescriptions = new JTextField("List Prescriptions", 20);
        prescriptions.setBackground(backgroundColor);
        savePrescription = new JButton("Save");
        savePrescription.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = allergies.getText();
                if (s.equals("Save")) {
                    JOptionPane.showMessageDialog(null, "Saved");
                    allergyContent.setText(s);
                    inputAllergies();
                    showAllergies();
                }
            }
        });

        dataContainer.add(img);
        informationPanel.add(nextVisit);
        informationPanel.add(phone);
        informationPanel.add(email);
        informationPanel.add(address);
        informationPanel.add(allergyLabel);
        informationPanel.add(allergies);
        informationPanel.add(saveAllergy);
        informationPanel.add(prescriptionLabel);
        informationPanel.add(prescriptions);
        informationPanel.add(savePrescription);
        dataContainer.add(informationPanel);
        add(dataContainer);
        setPreferredSize(new Dimension(400, 550));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inputAllergies(){
        fileName = info.getName() + info.getLastName() + ".pdf";
        try{
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(fileName));
            outputStream.println(s);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private void showAllergies(){
        fileName = info.getName() + info.getLastName() + ".pdf";
        try{
            Scanner inputStream = new Scanner(new FileInputStream(fileName));
            while(inputStream.hasNextLine()){
                s = inputStream.nextLine();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}